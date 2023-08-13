package com.abhi41.kesritourstaskone.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhi41.kesritourstaskone.domain.model.TourItem
import com.abhi41.kesritourstaskone.domain.use_case.GetTourInfo
import com.abhi41.kesritourstaskone.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TourInfoViewModel @Inject constructor(
    private val getTourInfo: GetTourInfo
) : ViewModel() {

    private val _state = mutableStateOf(TourInfoState())
    val state: State<TourInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }

    init {
        viewModelScope.launch {
            getTourInfo().onEach { result: Resource<List<TourItem>> ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            tourInfoItem = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            tourInfoItem = result.data ?: emptyList(),
                            isLoading = false
                        )
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                result.message ?: "Unknon error"
                            )
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            tourInfoItem = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}