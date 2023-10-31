package com.ozturksahinyetisir.personalappquiz

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ozturksahinyetisir.personalappquiz.model.Employee
import com.ozturksahinyetisir.personalappquiz.model.Employees
import com.ozturksahinyetisir.personalappquiz.network.ApiClient
import com.ozturksahinyetisir.personalappquiz.network.EmployeeService
import com.ozturksahinyetisir.personalappquiz.presentation.EmployeeScreen
import com.ozturksahinyetisir.personalappquiz.ui.theme.PersonalAppQuizTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    lateinit var employeeService: EmployeeService
    lateinit var employeeList: MutableList<Employee>
    val TAG ="MainTAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                employeeService = ApiClient.getClient().create(EmployeeService::class.java)
                var service = employeeService.getEmployees()

                service.enqueue(
                    object : Callback<Employees> {
                    override fun onFailure(call: Call<Employees>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Employees>, response: Response<Employees>) {

                        if (response.isSuccessful) {
                            employeeList = (response.body()?.data as MutableList<Employee>?)!!
                            Log.e(TAG, "onResponse: ${response.body()?.data}",)
                            Log.e(TAG, "onResponse: ${employeeList}",)

                            setContent {
                                PersonalAppQuizTheme {
                                    Surface(
                                        modifier = Modifier.fillMaxSize(),
                                        color = MaterialTheme.colorScheme.background
                                    ) {
                                        EmployeeScreen(employeeList)
                                    }
                                }
                            }
                        } else {
                            setContent {
                                PersonalAppQuizTheme {
                                    Surface(
                                        modifier = Modifier.fillMaxSize(),
                                        color = MaterialTheme.colorScheme.background
                                    ) {
                                        Column(verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(text = "Veri alınamadı!\nÇok fazla istek atıldı.\nTekrardan deneyiniz.",
                                                color = Color.Red,
                                                textAlign = TextAlign.Center)
                                        }
                                    }
                                }
                            }
                        }
                    }
                })
            }
        }

