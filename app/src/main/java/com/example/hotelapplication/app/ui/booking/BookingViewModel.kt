package com.example.hotelapplication.app.ui.booking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.Event
import com.example.base.MutableLiveEvent
import com.example.base.publishEvent
import com.example.hotelapplication.app.Singletons
import com.example.hotelapplication.app.model.EmptyFieldException
import com.example.hotelapplication.app.model.Field
import com.example.hotelapplication.app.model.booking.Booking
import com.example.hotelapplication.app.model.booking.BookingRepository
import com.example.hotelapplication.app.utils.share
import kotlinx.coroutines.launch

class BookingViewModel(
    private val bookingRepository: BookingRepository = Singletons.bookingRepository
) : ViewModel() {
    private var _booking = MutableLiveData<Booking>()
    val booking = _booking.share()

    private val _state = MutableLiveData(State())
    val state = _state.share()

    private val _navigateToPaid = MutableLiveData<Event<Unit>>()
    val navigateToTabsEvent = _navigateToPaid.share()

    private var _emptyFieldExceptionEvent = MutableLiveEvent<String>()
    var emptyFieldExceptionEvent = _emptyFieldExceptionEvent.share()

    fun navigate(name: String, serName: String) {
        try {
            startPay(name, serName)
        } catch (e: EmptyFieldException) {
            processEmptyFieldException(e)
        }

    }

    private fun startPay(name: String, serName: String) {
        if (name.isBlank()) throw EmptyFieldException(Field.Name)
        if (serName.isBlank()) throw EmptyFieldException(Field.Sername)
        _navigateToPaid.publishEvent(Unit)
    }

    private fun processEmptyFieldException(e: EmptyFieldException) {
        _state.value = _state.value?.copy(
            emptyName = e.field == Field.Name,
            emptySername = e.field == Field.Sername,
            emptyDate = e.field == Field.Birthdate,
            emptyСitizen = e.field == Field.Citezen,
            emptyNumСitizen = e.field == Field.NumCitezen,
            emptyDateEndСitizen = e.field == Field.DateEndCitezen,
        )
    }

    fun getBooking() {
        viewModelScope.launch {
            _booking.value = bookingRepository.getBooking()
        }
    }

    data class State(
        val emptyName: Boolean = false,
        val emptySername: Boolean = false,
        val emptyDate: Boolean = false,
        val emptyСitizen: Boolean = false,
        val emptyNumСitizen: Boolean = false,
        val emptyDateEndСitizen: Boolean = false,
    )
}