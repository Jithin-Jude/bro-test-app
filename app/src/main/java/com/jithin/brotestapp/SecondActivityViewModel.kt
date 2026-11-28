package com.jithin.brotestapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


/*
 * --------------------------------------------------------------------------
 * File: SecondActivityViewModel.dart
 * Developer: <Jithin/Jude>
 * Created: 23/11/26
 * Copyright © 2026. All rights reserved.
 * --------------------------------------------------------------------------
 */

class SecondActivityViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _count = savedStateHandle.getMutableStateFlow("", 0)
    val count = _count.asStateFlow()

    fun increment(){
        _count.value++
    }
}