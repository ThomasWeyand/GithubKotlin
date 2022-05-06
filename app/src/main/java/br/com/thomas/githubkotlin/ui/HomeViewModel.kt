package br.com.thomas.githubkotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.thomas.githubkotlin.model.Item
import br.com.thomas.githubkotlin.repository.IGithubRepository
import br.com.thomas.githubkotlin.ui.adapter.RepositoryPagingSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel(private val repository: IGithubRepository) : ViewModel() {

    private fun getRepositoryPagingData(): Flow<PagingData<Item>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PRE_FETCH_DISTANCE)) {
            RepositoryPagingSource(repository)
        }.flow

    }

    fun loadData(): Flow<PagingData<Item>> {
        return getRepositoryPagingData().cachedIn(viewModelScope)
    }

    companion object {
        private const val PAGE_SIZE = 100
        private const val PRE_FETCH_DISTANCE = 50
    }

}