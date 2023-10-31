package com.ozturksahinyetisir.personalappquiz.model

data class Employee(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    val id: Int,
    val profile_image: String
)

data class Employees(
    var status:String?,
    var message:String?,
    var data:List<Employee>?
)
