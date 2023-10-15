package com.kotlin.ytproject.databinding

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlin.ytproject.R

/**
 * Created by Charles Raj I on 10/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */

class DataBindingActivity : AppCompatActivity() {

    lateinit var activityBinding: ActivityDatabindingBinding

    lateinit var dataBindingViewModel: DataBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)
        dataBindingViewModel = DataBindingViewModel()

        activityBinding.localViewModel = dataBindingViewModel

    }

}