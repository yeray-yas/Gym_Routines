package com.yerayyas.gymroutines.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yerayyas.gymroutines.home.domain.useCases.GetRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase
) : ViewModel() {
    var state by mutableStateOf(HomeState())

    init {
       viewModelScope.launch {
           getRoutinesUseCase().stateIn(viewModelScope).collectLatest {
               state = state.copy(
                   routines = it
               )
           }
       }
    }
}