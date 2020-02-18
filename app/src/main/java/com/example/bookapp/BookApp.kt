package com.example.bookapp

import android.app.Application
import com.example.bookapp.framework.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class BookApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BookApp)
            fragmentFactory()
            modules(
                interactorModule,
                repositoryModule,
                apiModule,
                viewModelModule,
                fragmentModule,
                dataSourceModule,
                dbModule
            )
        }
    }

}