package com.painfulparse.cigarmadam.di

import android.app.Application
import androidx.room.Room
import com.painfulparse.cigarmadam.feature_cigars.data.source.local.CigarDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CigarMadamApplication : Application()