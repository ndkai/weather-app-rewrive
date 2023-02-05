package com.iot.weatherapp
import android.app.Application
import android.util.Log
import androidx.preference.PreferenceManager
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.iot.weatherapp.utils.ThemeManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class WeatherInstantApplication :  Application(), Configuration.Provider{

//    @Inject
//    lateinit var weatherRepository: WeatherRepository

    override fun onCreate() {
        super.onCreate()
    }

    private fun initTheme(){
        var preferences = PreferenceManager.getDefaultSharedPreferences(this)
        runCatching {
            ThemeManager.applyTheme(requireNotNull(preferences.getString("theme_key", "")))
        }.onFailure { exception -> exception.message?.let { Log.e("ThemeManager", it) } }
    }
    /**
     * @return The [Configuration] used to initialize WorkManager
     */
    override fun getWorkManagerConfiguration(): Configuration {
        var myWorkerFactory = DelegatingWorkerFactory()
//        myWorkerFactory.addFactory(MyWorkerFactory(weatherRepository))

        return Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .setWorkerFactory(myWorkerFactory)
            .build()
    }
}