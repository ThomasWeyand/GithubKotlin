package br.com.thomas.githubkotlin.di

import br.com.thomas.githubkotlin.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
}