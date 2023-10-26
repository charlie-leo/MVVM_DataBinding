package com.kotlin.ytproject.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.ytproject.data.Device
import com.kotlin.ytproject.databinding.adapter.DeviceAdapter

/**
 * Created by Charles Raj I on 16/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */

//@BindingAdapter("adapter")
//fun setAdapter(view: RecyclerView,device: Device){
//
//    if (view.adapter == null){
//        val deviceAdapter = DeviceAdapter()
//        view.layoutManager = LinearLayoutManager(view.context)
//        view.adapter = deviceAdapter
//    }else{
//        val adapter = view.adapter as DeviceAdapter
//        adapter.addItem(device)
//    }
//
//}

object CommonFields {

    @BindingAdapter("adapter")
    @JvmStatic fun RecyclerView.setAdapter(device: Device){
        if (device != null) {
            if (this.adapter == null) {
                val deviceAdapter = DeviceAdapter()
                this.layoutManager = LinearLayoutManager(this.context)
                this.adapter = deviceAdapter
            } else {
                val adapter = this.adapter as DeviceAdapter
                adapter.addItem(device)
            }
        }
    }

}