package ru.mrkurilin.mrKurilinCore.di.modules

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.mrkurilin.mrKurilinCore.di.qualifiers.ApplicationContext
import ru.mrkurilin.mrKurilinCore.di.scopes.AppScope
import ru.mrkurilin.mrKurilinCore.data.network.interceptors.NetworkCacheInterceptor
import java.util.concurrent.TimeUnit

private const val CONNECT_TIME = 5000L
private const val WRITE_TIME = 5000L
private const val READE_TIME = 5000L
private const val CACHE_SIZE = (5 * 1024 * 1024).toLong()

@Module
class NetworkModule {

    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @AppScope
    fun provideCache(
        @ApplicationContext
        context: Context,
    ): Cache = Cache(context.cacheDir, CACHE_SIZE)

    @Provides
    @AppScope
    fun provideOkHttpClient(
        cacheInterceptor: NetworkCacheInterceptor,
        cache: Cache,
    ): OkHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(cacheInterceptor)
        .addInterceptor(HttpLoggingInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIME, TimeUnit.SECONDS)
        .readTimeout(READE_TIME, TimeUnit.SECONDS)
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @AppScope
    fun provideBaseRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("") //todo: add baseUrl
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}