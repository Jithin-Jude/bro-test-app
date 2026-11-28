package com.jithin.brotestapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jithin.brotestapp.BroLogger.printLog
import com.jithin.brotestapp.ui.theme.BroTestAppTheme
import kotlinx.coroutines.launch

class SecondActivity : ComponentActivity() {

    companion object {
//        const val KEY_MESSAGE = "message"
        fun launchActivity(context: Context, message: String?) {
            val intent = Intent(context, SecondActivity::class.java)
//            intent.putExtra(KEY_MESSAGE, message)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLog("SecondActivity: onCreate")
        enableEdgeToEdge()

//        val message = intent.getStringExtra(KEY_MESSAGE)
//        printLog("$message")

//        lifecycle.currentState == Lifecycle.State.INITIALIZED
//
//        lifecycle.coroutineScope.launch {
//
//        }
//
//        lifecycleScope.launch {
//
//            repeatOnLifecycle(Lifecycle.State.RESUMED) {
//
//            }
//        }

        setContent {
            BroTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        SecondActivityContentView()
                    }
                }
            }
        }
    }
}

@Composable
fun SecondActivityContentView(modifier: Modifier = Modifier) {

    val count by secondActivityViewModel.count.collectAsStateWithLifecycle()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: $count"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            secondActivityViewModel.increment()
        }
        ) {
            Text("Increment Count")
        }
    }
}