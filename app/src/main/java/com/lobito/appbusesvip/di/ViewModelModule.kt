package com.lobito.appbusesvip.di

import com.lobito.appbusesvip.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val viewModule = module {

//    factoryOf(::LoginViewModel) // ME EVITO EL USO DE LOS GET() EN EL VIEWMODEL
//    viewModelOf(::LoginViewModel)
//    viewModel { LoginViewModel(get()) }
    viewModelOf(::LoginViewModel)

//    viewModel {
//        LoginViewModel()
//        LoginViewModel(context = get(), updateFlagUserUseCase = get(), validateUserUseCase = get() , verificateUserUseCase = get(), getPreferenceUseCase = get(), setPreferenceUseCase = get())
//    }
//    viewModel {
//        RegisterViewModel(context = get(), insertUserUseCase = get())
//    }
//    viewModel{
//        //HomeViewModel(get(), get(named(Constants.BLUETOOTH)), get(named(Constants.RED)), get(named(Constants.POS)))
//        HomeViewModel(context = get() ,bluetoothCommandHandler = get(named(Constants.BLUETOOTH)), getPreferenceUseCase = get(), setPreferenceUseCase = get())
//    }
//    viewModel{
//        ConfigurationViewModel(context = get(), logoutUserUseCase = get(), getPreferenceUseCase = get(), setPreferenceUseCase = get())
//    }

}