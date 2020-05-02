package com.brocodes.catspics.view.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessScrollListener(private val linearLayoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {

    // The minimum amount of items to have below your current scroll position before loading more.
    private val visibleThreshHold = 5

    // The current offset index of data you have loaded
    private var currentPage = 1

    // The total number of items in the dataset after the last load
    private var previousTotalItemCount  = 0

    // True if we are still waiting for the last set of data to load.
    private var isLoading = true

    // Sets the starting page index
    private val startingPageIndex = 0


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val lastVisibleItemIndex = linearLayoutManager.findLastVisibleItemPosition()
        val totalItemCount = linearLayoutManager.itemCount

        if(totalItemCount < previousTotalItemCount){
            currentPage = startingPageIndex
            previousTotalItemCount = totalItemCount
            if (totalItemCount == 0 ){
                isLoading = true
            }
        }

        // second case
        if (isLoading && (totalItemCount > previousTotalItemCount)) {
            isLoading = false
            previousTotalItemCount = totalItemCount
        }

        if (!isLoading && (lastVisibleItemIndex + visibleThreshHold) > totalItemCount) {
            currentPage++
            loadMore(currentPage, recyclerView)
            isLoading = true
        }
    }

    abstract fun loadMore(pageNumber : Int, recyclerView: RecyclerView)
}