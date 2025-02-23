package com.lobito.eatidentifiervip.data.common

sealed class Resource<out T> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error(val message: String, val cause: Throwable? = null) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}
