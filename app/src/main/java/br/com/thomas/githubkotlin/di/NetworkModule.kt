package br.com.thomas.githubkotlin.di

import androidx.annotation.NonNull
import br.com.thomas.githubkotlin.BuildConfig
import br.com.thomas.githubkotlin.network.GithubApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { githubApi(get()) }
    single { provideRetrofit(get()) }
    single { provideOkhttpClient() }
}

fun githubApi(@NonNull retrofit: Retrofit): GithubApi {
    return retrofit.create(GithubApi::class.java)
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


fun provideOkhttpClient(
): OkHttpClient =
    OkHttpClient.Builder()
        .build()