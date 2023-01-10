package com.example.tiptimecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

const val TAG = "main"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeScreen()
        }
    }
}

@Composable
fun TipTimeScreen(modifier: Modifier = Modifier) {

    var costOfService by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip), fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberfield(value = costOfService, onValueChange = { costOfService = it })
        Spacer(modifier = Modifier.height(16.dp))

        AmountsDisplayed(bill = costOfService.toDoubleOrNull() ?: 0.0)
    }
}

@Composable
fun EditNumberfield(value: String, onValueChange: (String) -> Unit) {

    TextField(value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text(
                stringResource(
                    id = R.string.cost_of_service)
            )
        })


}

@Composable
fun AmountsDisplayed(bill: Double) {

    val tip = calculateTip(bill)
    val total = "%.2f".format(Locale.US,tip.toDouble() + bill)

    Column() {
        Text(
            text = "Tip:                      $tip",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Text(
            text = "Total amount:    $total",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

private fun calculateTip(bill: Double, tipPercent: Double = 15.0): String {

    return "%.2f".format(Locale.US, bill * (tipPercent / 100))

}


































