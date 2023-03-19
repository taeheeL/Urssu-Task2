package com.example.urssu_task2.viewModel

import androidx.lifecycle.*
import com.example.urssu_task2.module.PW_PATTERN
import kotlinx.coroutines.flow.*

class SignUpViewModel : ViewModel() {

    val email: MutableLiveData<String> = MutableLiveData()

    private val emailEntered = Transformations.map(email) { it.isNotEmpty() }
    val isEmailEnteredLiveData: LiveData<Boolean> = emailEntered

    val password = MutableStateFlow("")

    val checkPasswordState = password.debounce(300L)
        .distinctUntilChanged()
        .map { if (it.isNullOrEmpty()) "empty" else if (it.matches(Regex(PW_PATTERN))) "valid" else "invalid" }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)


}