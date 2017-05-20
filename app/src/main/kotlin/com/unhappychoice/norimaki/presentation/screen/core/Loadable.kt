package com.unhappychoice.norimaki.presentation.screen.core

import com.unhappychoice.norimaki.extension.Variable
import io.reactivex.Observable

interface Loadable {
    val isLoading: Variable<Boolean>

    fun <T> Observable<T>.startLoading(): Observable<T> {
        isLoading.value = true
        return this
            .doOnError { isLoading.value = false }
            .doOnComplete { isLoading.value = false }
    }
}