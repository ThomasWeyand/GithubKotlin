package br.com.thomas.githubkotlin.ui.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.thomas.githubkotlin.model.Item
import br.com.thomas.githubkotlin.network.base.Result
import br.com.thomas.githubkotlin.repository.IGithubRepository
import retrofit2.HttpException
import java.io.IOException

class RepositoryPagingSource(private val repository: IGithubRepository) :
    PagingSource<Int, Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX
        return try {
            when (val response = repository.fetchRepositories(position)) {
                is Result.Success -> {
                    val repos = response.data.items
                    val nextKey = if (repos.isEmpty()) {
                        null
                    } else {
                        position + (params.loadSize / NETWORK_PAGE_SIZE)
                    }
                    LoadResult.Page(
                        data = repos,
                        prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - 1,
                        nextKey = nextKey
                    )
                }
                is Result.Error -> {
                    return LoadResult.Error(response.error)
                }
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 100
        private const val GITHUB_STARTING_PAGE_INDEX = 1
    }
}