package com.example.tiptimecompose

import android.os.Bundle
import com.example.tiptimecompose.ui.theme.TipTimeComposeTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        EditNumberfield()
    }
}

@Composable
fun EditNumberfield() {

    var costOfService by rememberSaveable { mutableStateOf("") }

    TextField(
        value = costOfService,
        onValueChange = { input -> costOfService = input },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text(
                stringResource(
                    id = R.string.cost_of_service
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
}

private fun calculateTip(amount: Double, tipPercent: Double){
    var totalTip = (amount * (tipPercent/100)) + amount
}



@Preview(showBackground = true)
@Composable
fun Preview() {

}




































