package br.com.thomas.githubkotlin

import android.app.Application
import br.com.thomas.githubkotlin.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubKotlinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@GithubKotlinApplication)
            modules(listOf(networkModule, repositoryModule, presentationModule))
        }
    }
}