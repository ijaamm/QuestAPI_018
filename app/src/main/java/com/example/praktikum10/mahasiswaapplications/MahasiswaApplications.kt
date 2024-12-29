package com.example.praktikum10.mahasiswaapplications

import android.app.Application
import com.example.praktikum10.mahasiswacontainer.AppContainer
import com.example.praktikum10.mahasiswacontainer.MahasiswaContainer

class MahasiswaApplications: Application()  {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}