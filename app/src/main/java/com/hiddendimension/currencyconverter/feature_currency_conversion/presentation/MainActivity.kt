package com.hiddendimension.currencyconverter.feature_currency_conversion.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.hiddendimension.currencyconverter.R
import com.hiddendimension.currencyconverter.databinding.ActivityMainBinding
import com.hiddendimension.currencyconverter.feature_currency_conversion.domain.model.ItemsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private var currencyCodes: Array<out String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currencyCodes = applicationContext.resources.getStringArray(R.array.currency_codes)

        binding.etFrom.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updateList()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        binding.spFromCurrency.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    updateList()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }



        lifecycleScope.launchWhenStarted {

            viewModel.conversion.collect { event ->

                when (event) {
                    is MainActivityViewModel.CurrencyEvent.Success -> {
                        fetchCurrency(event.currencyList)
                    }

                    is MainActivityViewModel.CurrencyEvent.Failure -> {
                        Toast.makeText(applicationContext, event.errorText, Toast.LENGTH_LONG)
                            .show()

                    }
                    is MainActivityViewModel.CurrencyEvent.Loading -> {
                    }

                    else -> Unit
                }
            }
        }
    }

    private fun updateList() {
        val amount = binding.etFrom.text
        val fromCurrency = binding.spFromCurrency.selectedItem.toString()

        viewModel.convert(
            amount.toString(),
            fromCurrency,
            currencyCodes as Array<out String>
        )
    }

    //The data set always fully changes
    @SuppressLint("NotifyDataSetChanged")
    private fun fetchCurrency(data: ArrayList<ItemsViewModel>) {

        if (binding.etFrom.text?.isNotEmpty() == true) {

            if (binding.listOfCurrencies.adapter == null) {
                val adapter = CurrencyCustomAdapter(data)
                binding.listOfCurrencies.adapter = adapter
            } else
                binding.listOfCurrencies.adapter?.notifyDataSetChanged()

        }

    }


}