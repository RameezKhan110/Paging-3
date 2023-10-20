package com.example.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination.api.QuotesService
import com.example.pagination.model.Result
import java.lang.Exception

class QuotesPagingSource: PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: 1
            val response = QuotesService.quotesInterface.getQuotes(position)
            LoadResult.Page(
                data = response.results,
                prevKey = if(position == 1) null else position - 1,
                nextKey = if(position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("TAG", "exception: $e")
            LoadResult.Error(e)
        }
    }
}