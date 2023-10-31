package com.ozturksahinyetisir.personalappquiz.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        val employeeService = retrofit?.create(EmployeeService::class.java)
        return retrofit as Retrofit
    }
}