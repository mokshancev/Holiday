package ru.createtogether.bottom_calendar.presenter

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import dagger.hilt.android.AndroidEntryPoint
import ru.createtogether.birthday.imageCalendar.model.MonthModel
import ru.createtogether.bottom_calendar.R
import ru.createtogether.bottom_calendar.databinding.BottomDialogCalendarBinding
import ru.createtogether.common.helpers.AdapterActions
import ru.createtogether.common.helpers.baseFragment.BaseBottomDialogFragment
import java.util.*

@AndroidEntryPoint
class CalendarBottomFragment : BaseBottomDialogFragment(R.layout.bottom_dialog_calendar) {

    private val binding: BottomDialogCalendarBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        binding.calendarView.date = time
    }

    private fun setListeners() {
        setCalendarDayClick()
    }

    private fun setCalendarDayClick() {
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            parentFragmentManager.setFragmentResult(CALENDAR_REQUEST, bundleOf(DATE_LONG to GregorianCalendar( year, month, dayOfMonth ).time.time))
            dismiss()
        }
    }

//    private fun initCalendarAdapter(months: List<MonthModel>){
//        with(binding.rv){
//            if(adapter == null)
//                adapter = MonthAdapter(initMonths = months)
//            else
//                (adapter as AdapterActions).setData(months)
//        }
//    }

    private val time by lazy {
        requireArguments().getLong(PARAM_TIME)
    }

    companion object {
        const val CALENDAR_REQUEST = "calendar_request"
        const val DATE_LONG = "date_long"

        private const val PARAM_TIME = "param_time"

        fun getInstance(time: Long) = CalendarBottomFragment().apply {
            arguments = bundleOf(PARAM_TIME to time)
        }
    }
}