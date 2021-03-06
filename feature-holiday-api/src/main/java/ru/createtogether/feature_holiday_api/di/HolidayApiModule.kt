package ru.createtogether.feature_holiday_api.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.createtogether.feature_holiday_api.api.HolidayApi

@Module
@InstallIn(SingletonComponent::class)
object HolidayApiModule {
    @Provides
    fun provideHolidayApi(retrofit: Retrofit): HolidayApi {
        return retrofit.create(HolidayApi::class.java)
    }
}