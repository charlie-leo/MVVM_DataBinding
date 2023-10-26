package com.kotlin.ytproject.databinding

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.ytproject.broadcast.BluetoothBroadcast
import com.kotlin.ytproject.data.Device
import com.kotlin.ytproject.databinding.adapter.DeviceAdapter

/**
 * Created by Charles Raj I on 10/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */
@SuppressLint("MissingPermission")
@RequiresApi(Build.VERSION_CODES.M)
class DataBindingViewModel(private var applicationContext: Context,private val bluetoothAdapter: BluetoothAdapter?) : ViewModel()
{

    private val deviceList = mutableListOf<Device>()

    val deviceAdapter = DeviceAdapter()

    val deviceLiveData = MutableLiveData<Device>()

    private val receiver = BluetoothBroadcast{ device ->

//        deviceList.add(Device(device.name,device.address))
//
//        deviceAdapter.addItem(Device(device.name,device.address))

        deviceLiveData.postValue(Device(device.name,device.address))
        Log.d("TAG", "Device name is ${device.name} address is ${device.address}")
    }


    fun startScan(view: View){
        if (applicationContext.checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED) {
            applicationContext.registerReceiver(
                receiver,
                IntentFilter(BluetoothDevice.ACTION_FOUND)
            )
            bluetoothAdapter?.startDiscovery()
        }
    }
    fun stopScan(view: View){
        applicationContext.unregisterReceiver(receiver)
    }

}