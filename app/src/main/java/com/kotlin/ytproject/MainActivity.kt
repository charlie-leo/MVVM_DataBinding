package com.kotlin.ytproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.ytproject.data.Device
import com.kotlin.ytproject.databinding.adapter.DeviceAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}