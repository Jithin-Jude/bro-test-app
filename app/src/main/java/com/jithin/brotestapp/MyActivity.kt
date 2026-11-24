package com.jithin.brotestapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jithin.brotestapp.BroLogger.printLog
import com.jithin.brotestapp.ui.theme.BroTestAppTheme


/*
 * --------------------------------------------------------------------------
 * File: MyActivity.dart
 * Developer: <Jithin/Jude>
 * Created: 24/11/26
 * Copyright © 2026. All rights reserved.
 * --------------------------------------------------------------------------
 */

class MyActivity: ComponentActivity() {

    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, MyActivity::class.java)
            context.startActivity(intent)
        }
    }
    private val viewModel: MyActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLog("SecondActivity: onCreate")
        enableEdgeToEdge()

        setContent {
            val count by viewModel.count.collectAsStateWithLifecycle()

            BroTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text("Count: $count")
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = {
                                viewModel.increment()
                            }) {
                                Text("Increment")
                            }
                        }
                    }
                }
            }
        }
    }
}