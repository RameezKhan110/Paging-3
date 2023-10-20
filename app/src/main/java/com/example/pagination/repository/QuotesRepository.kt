package com.example.pagination.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagination.QuotesPagingSource

class QuotesRepository {

    fun getQuotes() = Pager(
        PagingConfig( pageSize = 10, maxSize = 100),
        pagingSourceFactory = {QuotesPagingSource()}
    ).liveData
}