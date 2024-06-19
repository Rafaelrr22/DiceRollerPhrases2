package com.example.dicerollerphrases

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerphrases.ui.theme.DiceRollerPhrasesTheme

class MotivationalMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra("MESSAGE")
        Log.d("MotivationalMessageActivity", "Received message: $message")
        setContent {
           DiceRollerPhrasesTheme {
               MotivationalMessageScreen(message) {
                   finish()
               }
           }
        }
    }
}

@Composable
fun MotivationalMessageScreen (message: String?, onBackClick: () -> Unit) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
         horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = message ?: "No message")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackClick) {
            Text(text = "Back")

        }
    }
}


@Preview
@Composable
fun PreviewMotivationalMessageScreen(){
    DiceRollerPhrasesTheme {
        MotivationalMessageScreen(message = "Sample Message", onBackClick = {})
    }
}

