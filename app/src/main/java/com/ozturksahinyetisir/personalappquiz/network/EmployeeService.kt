package com.ozturksahinyetisir.personalappquiz.network

import com.ozturksahinyetisir.personalappquiz.model.Employees
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService {
    @GET("/api/v1/employees")
    fun getEmployees() : Call<Employees>
}