package com.syed.walmartproject.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syed.walmartproject.data.api.APIDetails
import com.syed.walmartproject.data.repository.CountryFactsRepositoryImpl
import com.syed.walmartproject.data.util.NetworkHelper
import com.syed.walmartproject.domain.usecase.GetCountryFactsUseCase
import com.syed.walmartproject.presentation.viewmodel.CountryViewModel
import com.syed.walmartproject.presentation.viewmodel.CountryViewModelFactory
import com.syed.walmartproject.R

class CountryFragment() : Fragment() {
    private lateinit var viewModel: CountryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryRecyclerViewAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = CountryFactsRepositoryImpl(APIDetails.service)
        val getCountriesFactsUseCase = GetCountryFactsUseCase(repository)
        val viewModelFactory = CountryViewModelFactory(getCountriesFactsUseCase)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CountryViewModel::class.java)
        progressBar = view.findViewById(R.id.progressBar)
        recyclerView = view.findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CountryRecyclerViewAdapter(arrayListOf())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.countriesFact.observe(viewLifecycleOwner, Observer { networkcase ->
            when (networkcase) {
                is NetworkHelper.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is NetworkHelper.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        context,
                        "Error fetching data: ${networkcase.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is NetworkHelper.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    adapter.updateCountries(networkcase.response)
                }
            }
        })
        viewModel.getCountryFacts()
    }
}