package com.kotlin.ytproject.databinding

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.kotlin.ytproject.R
import com.kotlin.ytproject.data.Device

/**
 * Created by Charles Raj I on 10/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */

@RequiresApi(Build.VERSION_CODES.M)
class DataBindingActivity : AppCompatActivity() {

    lateinit var activityBinding: ActivityDatabindingBinding
    lateinit var dataBindingViewModel: DataBindingViewModel


    private val bluetoothManager by lazy {
        applicationContext.getSystemService(BluetoothManager::class.java)
    }
    private val  bluetoothAdapter by lazy {
        bluetoothManager?.adapter
    }

    private val bluetoothIsEnabled: Boolean
        get() = bluetoothAdapter?.isEnabled == true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)
        dataBindingViewModel = DataBindingViewModel(applicationContext,bluetoothAdapter)
        activityBinding.localViewModel = dataBindingViewModel
        activityBinding.device = Device()
        val bluetoothLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}


        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
            it ->

            val enableBluetooth = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                it[Manifest.permission.BLUETOOTH_CONNECT] == true
            }else true

            if (enableBluetooth && !bluetoothIsEnabled){
                bluetoothLauncher.launch(
                    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                )
            }
        }


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT
                )
            )
        }

        dataBindingViewModel.deviceLiveData.observe(this, Observer {
            it?.let {
                activityBinding.device = it
            }

        })


    }

}