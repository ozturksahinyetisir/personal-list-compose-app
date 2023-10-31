package com.ozturksahinyetisir.personalappquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.ozturksahinyetisir.personalappquiz.network.ComposeResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var composeResponse: ComposeResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        composeResponse.fetchDataAndDisplay(this)
    }
}

