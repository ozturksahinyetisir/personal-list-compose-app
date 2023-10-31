package com.ozturksahinyetisir.personalappquiz.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozturksahinyetisir.personalappquiz.R
import com.ozturksahinyetisir.personalappquiz.model.Employee

@Composable
fun EmployeeScreen(employees: List<Employee>) {
    val montBold = FontFamily(Font(R.font.montserrat_bold))
    LazyColumn {
        items(employees) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Column(verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxSize()
                        .background(Color.LightGray)) {
                        Text(text = "${it.id}",
                            textAlign = TextAlign.Start,
                            color = Color.Red)
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = it.employee_name,
                            textAlign = TextAlign.Center,
                            fontFamily = montBold)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "${it.employee_salary}",
                            color = Color.Blue,
                            fontFamily = montBold,
                            fontSize = 20.sp,
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "₺",
                            fontFamily = montBold,
                            fontSize = 20.sp,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        }
    }
}