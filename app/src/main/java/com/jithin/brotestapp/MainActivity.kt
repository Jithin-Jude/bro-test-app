package com.jithin.brotestapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.jithin.brotestapp.BroLogger.printLog
import com.jithin.brotestapp.ui.theme.BroTestAppTheme

class MainActivity : ComponentActivity() {

    private var count by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLog("MainActivity: onCreate")
        count = savedInstanceState?.getInt("count") ?: 0
        val apiKey = BuildConfig.MIX_PANEL_API_KEY
        printLog("Mixpanel API Key: $apiKey")
        enableEdgeToEdge()
        setContent {
            BroTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Greeting(
                                name = "Android",
                                count = count,
                                apiKey = apiKey,
                                onIncrement = { count++ }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    SecondActivity.launchActivity(this@MainActivity, message = "Message From 1st Activity")
                                }
                            ) {
                                Text(stringResource(R.string.go_to_2nd_activity))
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Parent()
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        printLog("MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        printLog("MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        printLog("MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        printLog("MainActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLog("MainActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        printLog("MainActivity: onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
        printLog("MainActivity: onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        count = savedInstanceState.getInt("count")

        super.onRestoreInstanceState(savedInstanceState)
        printLog("MainActivity: onRestoreInstanceState")
    }
}

@Composable
fun Greeting(name: String, count: Int, apiKey: String, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name! Count: $count"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Mixpanel Key: $apiKey"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onIncrement) {
            Text("Increment")
        }
    }
}


// Kotlin Recomposition eg
@Composable
fun Parent() {
    var count by remember { mutableIntStateOf(0) }
    printLog("Compose: Parent")

    Column {
        printLog("Compose: Column")
        Child1(count)
        Child2()

        Button(onClick = { count++ }) {
            printLog("Compose: Button")
            Text("Increment")
        }
    }
}

@Composable
fun Child1(count: Int) {
    printLog("Compose: Child1")
    Text("Count: $count")
}

@Composable
fun Child2() {
    printLog("Compose: Child2")
    Text("Static content")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BroTestAppTheme {
        Greeting("Android", count = 0, apiKey = "ABCD", onIncrement = {})
    }
}