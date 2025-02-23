package com.lobito.eatidentifiervip.di

import com.lobito.eatidentifiervip.presentation.login.LoginViewModel
import com.lobito.eatidentifiervip.presentation.splash.SplashViewModel

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)

}