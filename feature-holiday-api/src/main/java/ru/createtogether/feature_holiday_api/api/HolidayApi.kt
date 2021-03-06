package ru.createtogether.feature_holiday_api.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.createtogether.feature_day_utils.model.DayOfMonthModel
import ru.createtogether.feature_day_utils.model.NextDayModel
import ru.createtogether.feature_holiday_utils.model.HolidaysByIdRequest
import ru.createtogether.feature_holiday_utils.model.HolidayModel

interface HolidayApi {

    @GET("/holidays/{date}")
    suspend fun loadHolidays(@Path("date") date: String): Response<List<HolidayModel>>

    @GET("/holidays/{date}/nearest_holiday_day")
    suspend fun loadNextDateWithHolidays(@Path("date") date: String): Response<NextDayModel>

    @POST("/holidays")
    suspend fun loadHolidaysByIds(@Body holidaysByIdRequest: HolidaysByIdRequest): Response<List<HolidayModel>>

    @GET("/holidays/{date}/holidays_of_month_preview")
    suspend fun loadHolidaysOfMonth(@Path("date") date: String): Response<List<DayOfMonthModel>>
}