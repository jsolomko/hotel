package com.example.hotelapplication.app.ui.booking

import android.content.Context
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.Event
import com.example.base.MutableLiveEvent
import com.example.base.publishEvent
import com.example.hotelapplication.app.model.EmailValidationException
import com.example.hotelapplication.app.model.EmptyFieldException
import com.example.hotelapplication.app.model.Field
import com.example.hotelapplication.app.model.booking.Booking
import com.example.hotelapplication.app.model.booking.BookingRepository
import com.example.hotelapplication.app.utils.BaseViewModel
import com.example.hotelapplication.app.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val bookingRepository: BookingRepository
) : BaseViewModel(context) {
    private var _booking = MutableLiveData<Booking>()
    val booking = _booking.share()

    private val _state = MutableLiveData(State())
    val state = _state.share()

    private val _navigateToPaid = MutableLiveData<Event<Unit>>()
    val navigateToTabsEvent = _navigateToPaid.share()

    private var _emptyFieldExceptionEvent = MutableLiveEvent<String>()
    var emptyFieldExceptionEvent = _emptyFieldExceptionEvent.share()

    private var _emailExceptionEvent = MutableLiveData<State>()
    var emailExceptionEvent = _emailExceptionEvent.share()

    fun navigateToPay(name: String, serName: String, email: String) {
        try {
            startPay(name, serName, email)
        } catch (e: EmptyFieldException) {
            processEmptyFieldException(e)
        } catch (e: EmailValidationException) {
            processEmailException(e)
        }
    }

    private fun processEmailException(e: EmailValidationException) {
        _emailExceptionEvent.value = State(emptyCitizen = e.field == Field.Citezen)
    }

    private fun startPay(name: String, serName: String, email: String) {
        if (name.isBlank()) throw EmptyFieldException(Field.Name)
        if (serName.isBlank()) throw EmptyFieldException(Field.Sername)
        if (!Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) throw EmailValidationException(Field.Citezen)
        _navigateToPaid.publishEvent(Unit)
    }

    private fun processEmptyFieldException(e: EmptyFieldException) {
        _state.value = _state.value?.copy(
            emptyName = e.field == Field.Name,
            emptySername = e.field == Field.Sername,
            emptyDate = e.field == Field.Birthdate,
            emptyCitizen = e.field == Field.Citezen,
            emptyNumCitizen = e.field == Field.NumCitezen,
            emptyDateEndCitizen = e.field == Field.DateEndCitezen,
        )
    }

    fun getBooking() {
        viewModelScope.safeLaunch {
            delay(2000)
            _booking.value = bookingRepository.getBooking()
        }
    }

    data class State(
        val emptyName: Boolean = false,
        val emptySername: Boolean = false,
        val emptyDate: Boolean = false,
        val emptyCitizen: Boolean = false,
        val emptyNumCitizen: Boolean = false,
        val emptyDateEndCitizen: Boolean = false,
    ) {
    }

    enum class TextFieldType {
        EMAIL,
        PASSWORD
    }
}