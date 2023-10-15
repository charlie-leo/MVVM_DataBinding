package com.kotlin.ytproject.databinding

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel

/**
 * Created by Charles Raj I on 10/10/23
 * @project Kotlin YT Project
 * @author Charles Raj
 */
class DataBindingViewModel: ViewModel()
{
    var nameText : String = ""
    var ageText : String = ""
    var genderText : String = ""
    var placeText : String = ""

    fun saveClick(view: View){
        Log.d("TAG", "name text : ${nameText}")
        Log.d("TAG", "age text : ${ageText}")
        Log.d("TAG", "gender text : ${genderText}")
        Log.d("TAG", "place text : ${placeText}")

        Toast.makeText(
            view.context,
            "The person name is ${nameText} in the age ${ageText}," +
                    " his gender ${genderText} is from ${placeText}",
            Toast.LENGTH_SHORT
        ).show()
    }

}