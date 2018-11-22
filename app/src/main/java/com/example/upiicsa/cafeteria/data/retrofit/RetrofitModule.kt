package com.example.upiicsa.cafeteria.data.retrofit



import android.arch.core.BuildConfig
import android.os.Build
import com.example.upiicsa.cafeteria.data.ApiGateway
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRemoteOrderRepository(cafeteriaApiService: CafeteriaApiService) = RetrofitApiGateway(cafeteriaApiService)


    @Provides
    @Singleton
    fun provideCafeteriaApiService(retrofit: Retrofit) = retrofit.create<CafeteriaApiService>(CafeteriaApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val userAgent = "${BuildConfig.APPLICATION_ID}/${BuildConfig.VERSION_NAME} (Linux; Android ${Build.VERSION.SDK_INT})"

        return OkHttpClient.Builder()
                .addInterceptor(UserAgentInterceptor(userAgent))
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.43.12:4000/api/")
            .build()
}
