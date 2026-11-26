package com.jithin.brotestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jithin.brotestapp.ui.theme.BroTestAppTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle


/*
 * --------------------------------------------------------------------------
 * File: MyExamActivity.kt
 * Developer: <Jithin/Jude>
 * Created: 26/11/26
 * Copyright © 2026. All rights reserved.
 * --------------------------------------------------------------------------
 */

class MyExamActivity: ComponentActivity() {
    val myExamVm: MyExamActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BroTestAppTheme {
                val text by myExamVm.myText.collectAsStateWithLifecycle()
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = text,
                        onValueChange = {
                            myExamVm.updateMyText(it)
                        },
                    )
                }
            }
        }
    }
}
