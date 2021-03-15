package com.exam_prep.bcs.viewmodel

import android.app.Application
import android.content.Intent

class AppTourViewModel(application: Application) : BCSViewModel(application) {
    fun showAppDashboard() {
//        activitySwitchLiveData.value = Triple(
//            ActivityStartType.SwitchActivity,
//            Intent(getApplication(), PriyoNewDashboardActivity::class.java),
//            true
//        )
    }
}