package com.kotlin.ytproject.databinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.ytproject.R
import com.kotlin.ytproject.data.Device
import com.kotlin.ytproject.databinding.DeviceItemBinding

/**
 * Created by Charles Raj I on 16/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */
class DeviceAdapter: RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    private val deviceList = mutableListOf<Device>()

    fun addItem(device: Device){
        deviceList.add(device)
//        notifyItemInserted(deviceList.size +1)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val view = DataBindingUtil.inflate<DeviceItemBinding>(LayoutInflater.from(parent.context), R.layout.device_item,parent,false)
        return DeviceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val device = deviceList[position]
        holder.bind(device)
    }

    class DeviceViewHolder(private val deviceItem: DeviceItemBinding) : RecyclerView.ViewHolder(deviceItem.root){

        fun bind(device: Device) {
            deviceItem.device = device
        }

    }

}