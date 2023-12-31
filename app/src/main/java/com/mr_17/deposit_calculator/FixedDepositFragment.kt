package com.mr_17.deposit_calculator

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.mr_17.deposit_calculator.databinding.FragmentFixedDepositBinding

class FixedDepositFragment : Fragment(R.layout.fragment_fixed_deposit) {
    private lateinit var binding: FragmentFixedDepositBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFixedDepositBinding.bind(view)

        (activity as MainActivity).setToolbarTitle(getString(R.string.fixed_deposit))

        initializeUI()
    }

    private fun initializeUI() {
        binding.apply {
            dropdownDepositScheme.apply{
                tvLabel.heading.text = "Deposit Scheme"

                val items = resources.getStringArray(R.array.list_items_deposit_scheme)
                val adapter =
                    ArrayAdapter(requireContext(), R.layout.item_dropdown_menu, items)
                (dropdown.editText as? AutoCompleteTextView)?.apply {
                    setText(items[0])
                    setAdapter(adapter)
                }
            }
            dropdownInterestPayment.apply{
                tvLabel.heading.text = "Interest Payment"

                val items = resources.getStringArray(R.array.list_items_interest_payment)
                val adapter =
                    ArrayAdapter(requireContext(), R.layout.item_dropdown_menu, items)
                (dropdown.editText as? AutoCompleteTextView)?.apply {
                    setText(items[0])
                    setAdapter(adapter)
                }
            }
            etAmount.apply {
                tvLabel.heading.text = "Amount"
                inputTextField.editText?.apply {
                    text = Editable.Factory.getInstance().newEditable("0")
                    inputType = InputType.TYPE_CLASS_NUMBER
                }
            }
            etYear.apply {
                tvLabel.heading.text = "Year"
                inputTextField.editText?.apply {
                    text = Editable.Factory.getInstance().newEditable("0")
                    inputType = InputType.TYPE_CLASS_NUMBER
                }
            }
            etMonth.apply {
                tvLabel.heading.text = "Month"
                inputTextField.editText?.apply {
                    text = Editable.Factory.getInstance().newEditable("0")
                    inputType = InputType.TYPE_CLASS_NUMBER
                }
            }
            etDay.apply {
                tvLabel.heading.text = "Day"
                inputTextField.editText?.apply {
                    text = Editable.Factory.getInstance().newEditable("0")
                    inputType = InputType.TYPE_CLASS_NUMBER
                }
            }
            btnCalculate.apply {
                button.text = "Calculate"
            }
        }
    }
}