package tat.mukhutdinov.memes.infrastructure

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tat.mukhutdinov.android.structure.AppDispatchers
import tat.mukhutdinov.android.structure.Dispatchers

object InfrastructureModule {

    val module = module {

        single<Dispatchers> {
            AppDispatchers()
        }

        single {
            Retrofit.Builder()
                .baseUrl("https://api.imgflip.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }

        single {
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
    }
}