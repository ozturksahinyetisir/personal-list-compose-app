package com.ozturksahinyetisir.personalappquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.ozturksahinyetisir.personalappquiz.network.ComposeResponse

class MainActivity : ComponentActivity() {
    private val composeResponse = ComposeResponse()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        composeResponse.fetchDataAndDisplay(this)
    }
}

