package com.jithin.brotestapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.serialization.saved
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


/*
 * --------------------------------------------------------------------------
 * File: MyExamActivityViewModel.dart
 * Developer: <Jithin/Jude>
 * Created: 26/11/26
 * Copyright © 2026. All rights reserved.
 * --------------------------------------------------------------------------
 */

class MyExamActivityViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _myText = savedStateHandle.getMutableStateFlow(  "my_text", "" )
    val myText = _myText.asStateFlow()

    fun updateMyText(value: String) {
        _myText.value = value
    }
}