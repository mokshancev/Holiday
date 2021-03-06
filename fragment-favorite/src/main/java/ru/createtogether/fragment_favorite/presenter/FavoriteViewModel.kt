package ru.createtogether.fragment_favorite.presenter

import ru.createtogether.common.helpers.Event
import ru.createtogether.common.helpers.Status
import ru.createtogether.common.helpers.baseFragment.BaseViewModel
import ru.createtogether.feature_holiday_impl.R
import ru.createtogether.feature_holiday_utils.model.HolidayModel

class FavoriteViewModel : BaseViewModel() {
    fun updateSort(sortId: Int, data: List<HolidayModel>) = data.sortedBy { holiday ->
        when (sortId) {
            R.id.idName -> holiday.title
            else -> {
                holiday.date
            }
        }
    }
}