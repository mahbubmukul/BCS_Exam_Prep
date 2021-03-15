package com.exam_prep.bcs.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.exam_prep.bcs.BCSApplication
import com.exam_prep.bcs.viewmodel.listener.AlertMessageListener
import com.exam_prep.bcs.viewmodel.listener.InputErrorListener
import com.exam_prep.bcs.viewmodel.listener.ProgressDialogListener

open class BCSViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        const val POSITIVE_ACTION = 1
        const val NEGATIVE_ACTION = 2
    }

    protected val preferences = BCSApplication.preferences

    val requestPermissionRationaleActionLiveData = MutableLiveData<Int>()
    val askPermissionsResultLiveData = MutableLiveData<Pair<Int, Array<out String>>>()
    val activitySwitchLiveData = MutableLiveData<Triple<ActivityStartType, Intent, Boolean>>()
    val activityResultLiveData = MutableLiveData<Pair<Int, Intent>>()

    var progressDialogListener: ProgressDialogListener? = null
    var alertMessageListener: AlertMessageListener? = null
    var inputErrorListener: InputErrorListener? = null

    fun askForPermission(permissions: Array<String>, requestCode: Int) {
        askPermissionsResultLiveData.value = requestCode to permissions
    }

    open fun createRationaleDialog(
        positiveAction: (() -> Unit) = {
            requestPermissionRationaleActionLiveData.value = POSITIVE_ACTION
        }, negativeAction: (() -> Unit) = {
            requestPermissionRationaleActionLiveData.value = NEGATIVE_ACTION
        }
    ) {
        //TODO: Make this function abstract.
    }
}