package com.jithin.brotestapp

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

class SecondActivityViewModel: ViewModel() {

    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun increment(){
        _count.value++
    }
}