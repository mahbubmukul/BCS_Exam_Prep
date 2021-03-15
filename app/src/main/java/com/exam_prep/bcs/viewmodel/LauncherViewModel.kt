package com.exam_prep.bcs.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.LifecycleObserver
import com.exam_prep.bcs.activity.AppTourActivity

class LauncherViewModel(application: Application) : BCSViewModel(application), LifecycleObserver {

    fun startDashboard() {
        val intent = Intent(getApplication(), AppTourActivity::class.java)
        activitySwitchLiveData.value = Triple(ActivityStartType.SwitchActivity, intent, true)

    }

}