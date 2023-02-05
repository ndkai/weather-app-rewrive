package com.iot.weatherapp.ui.home

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.snackbar.Snackbar
import com.iot.weatherapp.ui.BaseFragment
import com.iot.weatherapp.ui.R
import com.iot.weatherapp.ui.databinding.FragmentHomeBinding
import  com.iot.weatherapp.utils.GPS_REQUEST_CHECK_SETTINGS
import  com.iot.weatherapp.utils.GpsUtil
import  com.iot.weatherapp.utils.SharedPreferenceHelper
import  com.iot.weatherapp.utils.convertCelsiusToFahrenheit
import  com.iot.weatherapp.utils.observeOnce
//import  com.iot.weatherapp.worker.UpdateWeatherWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private var isGPSEnabled = false

    @Inject
    lateinit var prefs: SharedPreferenceHelper

//    private val viewModel by viewModels<HomeFragmentViewModel> { viewModelFactoryProvider }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GpsUtil(requireContext()).turnGPSOn(object : GpsUtil.OnGpsListener {
            override fun gpsStatus(isGPSEnabled: Boolean) {
                this@HomeFragment.isGPSEnabled = isGPSEnabled
            }
        })
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()
    }

    private fun invokeLocationAction() {
//        when {
//            allPermissionsGranted() -> {
//                viewModel.fetchLocationLiveData().observeOnce(
//                    viewLifecycleOwner,
//                    { location ->
//                        if (location != null) {
//                            viewModel.getWeather(location)
//                            setupWorkManager()
//                        }
//                    }
//                )
//            }
//
//            shouldShowRequestPermissionRationale() -> {
//                AlertDialog.Builder(requireContext())
//                    .setTitle(getString(R.string.location_permission))
//                    .setMessage(getString(R.string.access_location_message))
//                    .setNegativeButton(
//                        getString(R.string.no)
//                    ) { _, _ -> requireActivity().finish() }
//                    .setPositiveButton(
//                        getString(R.string.ask_me)
//                    ) { _, _ ->
//                        requestPermissions(REQUIRED_PERMISSIONS, LOCATION_REQUEST_CODE)
//                    }
//                    .show()
//            }
//
//            !isGPSEnabled -> {
//                showShortSnackBar(getString(R.string.gps_required_message))
//            }
//
//            else -> {
//                requestPermissions(REQUIRED_PERMISSIONS, LOCATION_REQUEST_CODE)
//            }
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

  
}
