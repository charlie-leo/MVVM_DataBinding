package com.kotlin.ytproject.broadcast

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.kotlin.ytproject.data.Device

/**
 * Created by Charles Raj I on 16/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */
class BluetoothBroadcast(private val scannedDivice: (Device) -> Unit): BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            BluetoothDevice.ACTION_FOUND -> {
                val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE,BluetoothDevice::class.java)
                }else{
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                }
                device?.let{
                    if(it.name!=null){
                        scannedDivice(Device(it.name,it.address))
                    }else{
                        scannedDivice(Device("No name",it.address))
                    }

                }
            }
        }
    }
}