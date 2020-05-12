package com.brocodes.catspics.ui



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.brocodes.catspics.data.CutePawsDataSource
import com.brocodes.catspics.data.ImageItem
import com.brocodes.catspics.data.PixabayMethods
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class CutePawViewModel @Inject constructor(private val pixabayMethods: PixabayMethods, private val petType : String) : ViewModel() {
    var cutePawsLiveData: LiveData<PagedList<ImageItem>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()

        cutePawsLiveData = initializedPageListBuilder(config).build()
    }

    private fun initializedPageListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, ImageItem> {


        val dataSourceFactory = object : DataSource.Factory<Int, ImageItem>() {
            override fun create(): DataSource<Int, ImageItem> {
                return CutePawsDataSource(pixabayMethods, petType)
            }
        }
        return LivePagedListBuilder(dataSourceFactory, config)
    }

}

