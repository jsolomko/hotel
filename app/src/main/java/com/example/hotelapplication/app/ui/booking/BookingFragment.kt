package com.example.hotelapplication.app.ui.booking

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.telephony.PhoneNumberUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.app.ui.booking.BookingViewModel_Factory.create
import com.example.hotelapplication.app.utils.DigitTextWatcher
import com.example.hotelapplication.app.utils.EditTextWatcher
import com.example.hotelapplication.app.utils.EmptyTextWatcher
import com.example.hotelapplication.app.view.TouristCustomView
import com.example.hotelapplication.databinding.FragmentBookingBinding
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.MaskTransformation

@AndroidEntryPoint
class BookingFragment : Fragment(R.layout.fragment_booking) {
    lateinit var binding: FragmentBookingBinding
    private val viewModel by viewModels<BookingViewModel>()
    private var touristCounter: Int = 0
    private var sum: Int? = null
    private var touristView: TouristCustomView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentBookingBinding.inflate(inflater, container, false)

        viewModel.getBooking()
        viewModel.booking.observe(viewLifecycleOwner) { booking ->
            with(binding) {

                tvHotelName.text = booking.hotel_name
                tvHotelAddress.text = booking.hotel_adress

                tvDeparture.text = booking.departure
                tvArrivalCountry.text = booking.arrival_country
                tvTourDateStart.text = booking.tour_date_start
                tvTourDateStop.text = booking.tour_date_stop
                tvNumberOfNights.text = booking.number_of_nights.toString()
                tvHotelNameRoom.text = booking.hotel_name
                tvRoom.text = booking.room
                tvNutrition.text = booking.nutrition
                tvTourPrice.text = booking.tour_price.toString()
                tvFuel.text = booking.fuel_charge.toString()
                tvService.text = booking.service_charge.toString()

                val sumPrice = booking.service_charge?.let {
                    booking.fuel_charge?.plus(it)
                        ?.let { booking.tour_price?.plus(it) }
                }
                sum = sumPrice

                tvToPay.text = sumPrice.toString()

                imageViewExpand.setOnClickListener {
                    if (touristListLayout.visibility == View.VISIBLE) {
                        touristListLayout.visibility = View.GONE
                        imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    } else {
                        touristListLayout.visibility = View.VISIBLE
                        imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    }
                }
            }
            binding.btnToPay.text = getString(R.string.to_pay, sum.toString())

        }




        binding.imageViewAddNewTourist.setOnClickListener {
            addNewTouristCardView()
        }

        val phoneEdit: TextInputEditText = binding.textInputEditTextPhone

        binding.btnToPay.setOnClickListener {
            touristView?.validate()
            viewModel.navigate(
                binding.nameEditText.text.toString(),
                binding.touristSernameEditText.text.toString(),
                binding.EditTextEmail.text.toString()
            )
            println(phoneEdit.text.toString())

        }


//        phoneEdit.addTextChangedListener(EditTextWatcher(phoneEdit))
        phoneEdit.addTextChangedListener(PhoneNumberFormattingTextWatcher("RU"))



        observeState()
        observeEmailNotCorrectEvent()
        observeNavigateToPaidEvent()
        return binding.root
    }


    private fun observeState() = viewModel.state.observe(viewLifecycleOwner) {
        binding.touristName.error = if (it.emptyName) getString(R.string.field_is_empty) else null
        binding.touristSername.error =
            if (it.emptySername) getString(R.string.field_is_empty) else null

    }

    private fun addNewTouristCardView() {
        touristView = TouristCustomView(touristCounter, requireContext())
        binding.touristListLayoutMain.addView(touristView)
        touristCounter += 1

    }

    private fun observeEmailNotCorrectEvent() {
        viewModel.emailExceptionEvent.observe(viewLifecycleOwner) {
            binding.textInputLayoutEmail.error =
                if (it.emptyCitizen) getString(R.string.field_not_valid) else null
        }
    }

    private fun observeNavigateToPaidEvent() =
        viewModel.navigateToTabsEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_bookingFragment_to_paidFragment)
        }


}