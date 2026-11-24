package com.jithin.brotestapp

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.serialization.saved
import kotlinx.coroutines.flow.asStateFlow


/*
 * --------------------------------------------------------------------------
 * File: MyActivityViewModel.dart
 * Developer: <Jithin/Jude>
 * Created: 24/11/26
 * Copyright © 2026. All rights reserved.
 * --------------------------------------------------------------------------
 */

class MyActivityViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _count = savedStateHandle.getMutableStateFlow("count", 0)
    val count = _count.asStateFlow()

    fun increment() {
        _count.value++
    }
}