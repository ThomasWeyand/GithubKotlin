package br.com.thomas.githubkotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.githubkotlin.databinding.ActivityHomeBinding
import br.com.thomas.githubkotlin.ui.adapter.RepositoryAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val adapter by lazy { RepositoryAdapter() }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecycler()
        loadListData()
    }

    private fun initRecycler() {
        binding.run {
            repositoryRecycler.apply {
                layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
                adapter = this@HomeActivity.adapter
            }
        }
    }

    private fun loadListData() {
        lifecycleScope.launch {
            homeViewModel.loadData().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}