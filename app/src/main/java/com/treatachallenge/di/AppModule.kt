package com.treatachallenge.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.treatachallenge.data.MovieApi
import com.treatachallenge.data.local.AppDatabase
import com.treatachallenge.utils.ClientProvider.Companion.provideOkHttpClient
import com.treatachallenge.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun createRetrofitInstance(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(provideOkHttpClient())
            .build()

    }

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase
    = Room.databaseBuilder(context,AppDatabase::class.java,"database")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideMovieDao(db: AppDatabase) = db.movieDao()

}
