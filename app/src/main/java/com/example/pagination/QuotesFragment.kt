package com.example.pagination

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagination.adapter.LoadStateAdapter
import com.example.pagination.adapter.QuotesPagingAdapter
import com.example.pagination.databinding.FragmentQuotesBinding
import com.example.pagination.viewmodel.QuotesViewModel

class QuotesFragment : Fragment() {

    private lateinit var binding: FragmentQuotesBinding
    private val quotesPagingAdapter = QuotesPagingAdapter()
    private val quotesViewModel: QuotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuotesBinding.inflate(layoutInflater, container, false)

        binding.Rv.layoutManager = LinearLayoutManager(requireContext())
        binding.Rv.adapter = quotesPagingAdapter.withLoadStateHeaderAndFooter(header = LoadStateAdapter(), footer = LoadStateAdapter())

        quotesViewModel.quotesList.observe(viewLifecycleOwner) {
            Log.d("TAG", "data: $it")
            quotesPagingAdapter.submitData(lifecycle, it)
        }

        return binding.root
    }

}