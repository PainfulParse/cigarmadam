package com.painfulparse.cigarmadam

import android.app.Application
import androidx.room.Room
import com.painfulparse.cigarmadam.data.source.local.CigarDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CigarMadamApplication : Application()