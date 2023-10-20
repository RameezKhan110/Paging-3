package com.example.pagination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagination.repository.QuotesRepository

class QuotesViewModel: ViewModel() {

    private val quotesRepo = QuotesRepository()
    val quotesList = quotesRepo.getQuotes().cachedIn(viewModelScope)
}