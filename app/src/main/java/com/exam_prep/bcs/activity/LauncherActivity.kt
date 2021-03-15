package com.exam_prep.bcs.activity

import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import androidx.lifecycle.ViewModelProviders
import com.exam_prep.bcs.R
import com.exam_prep.bcs.viewmodel.LauncherViewModel

class LauncherActivity : BCSActivity() {

    companion object {
        private val TAG = LauncherActivity::class.java
    }

    private lateinit var launcherViewModel: LauncherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        launcherViewModel = getViewModel()
//        val deviceNumericId = Math.abs(this.getDeviceId().hashCode().toLong())
//        SharedPreferenceUtil.setDeviceId(deviceNumericId)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        launchHomeActivity()
    }

    private fun launchHomeActivity() {
            Handler().postDelayed({
                launcherViewModel.startDashboard()
            }, 2000)
            //launcherViewModel.performAppLaunchAction()
    }

    override fun createPriyoViewModel() = ViewModelProviders.of(this)[LauncherViewModel::class.java]

}