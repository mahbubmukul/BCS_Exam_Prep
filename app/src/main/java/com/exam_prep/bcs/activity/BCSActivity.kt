@file:Suppress("DEPRECATION")

package com.exam_prep.bcs.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.forEach
import androidx.lifecycle.Observer
import com.exam_prep.bcs.R
import com.exam_prep.bcs.util.PriyoLog
import com.exam_prep.bcs.util.createProgressDialog
import com.exam_prep.bcs.util.showShortToast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.exam_prep.bcs.viewmodel.ActivityStartType
import com.exam_prep.bcs.viewmodel.BCSViewModel
import com.exam_prep.bcs.viewmodel.listener.AlertMessageListener
import com.exam_prep.bcs.viewmodel.listener.AlertType
import com.exam_prep.bcs.viewmodel.listener.InputErrorListener
import com.exam_prep.bcs.viewmodel.listener.ProgressDialogListener

abstract class BCSActivity : AppCompatActivity(), ProgressDialogListener, AlertMessageListener,
    InputErrorListener {

    companion object {
        const val REQUEST_CODE_KEY = "REQUEST_CODE"
        const val DEFAULT_REQUEST_CODE = 1001
        private val TAG = BCSActivity::class.java
    }

    override val progressDialog: ProgressDialog by createProgressDialog()
    override val errorInputArray = SparseArray<View>()

    private lateinit var activityViewModel: BCSViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        PriyoLog.d(TAG, "onCreate(savedInstanceState: Bundle?)")
//        setupLanguage()
        super.onCreate(savedInstanceState)

        activityViewModel = createPriyoViewModel()
        activityViewModel.progressDialogListener = this
        activityViewModel.alertMessageListener = this
        activityViewModel.inputErrorListener = this

        activityViewModel.activitySwitchLiveData.observe(this, Observer {
            if (it != null) {
                val (switchType, intent, shouldFinishActivity) = it
                when (switchType) {
                    ActivityStartType.SwitchActivity -> {
                        startActivity(intent)
                    }
                    ActivityStartType.SwitchActivityForResult -> {
                        val requestCode = intent.getIntExtra(REQUEST_CODE_KEY, DEFAULT_REQUEST_CODE)
                        startActivityForResult(intent, requestCode)
                    }
                }
                if (shouldFinishActivity) {
                    finish()
                }
            }
        })
        activityViewModel.activityResultLiveData.observe(this, Observer {
            if (it != null) {
                val (resultCode, data) = it
                setResult(resultCode, data)
                finish()
            }
        })
    }

//    private fun setupLanguage() {
//        val locale = when (SharedPreferenceUtil.getAppLanguage()) {
//            "bn" -> {
//                Locale("bn")
//            }
//            else -> {
//                Locale.US
//            }
//        }
//        Locale.setDefault(locale)
//        val appConfig = resources.configuration
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            appConfig.setLocales(LocaleList(locale))
//        }
//        appConfig.locale = locale
//        application.baseContext.resources.updateConfiguration(appConfig, resources.displayMetrics)
//        application.resources.updateConfiguration(appConfig, resources.displayMetrics)
//        resources.updateConfiguration(appConfig, resources.displayMetrics)
//
//        application.baseContext.createConfigurationContext(appConfig)
//        application.createConfigurationContext(appConfig)
//        createConfigurationContext(appConfig)
//    }

    @Suppress("UNCHECKED_CAST")
    fun <T : BCSViewModel> getViewModel() = activityViewModel as T

    abstract fun createPriyoViewModel(): BCSViewModel

    override fun showProgressDialog(resId: Int, isCancelable: Boolean) =
        showProgressDialog(getString(resId), isCancelable)

    override fun showProgressDialog(message: String, isCancelable: Boolean) {
        PriyoLog.d(TAG, "showProgressDialog(message: $message, isCancelable: $isCancelable)")
        progressDialog.setCancelable(isCancelable)
        progressDialog.setTitle(R.string.please_wait)
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    override fun hideProgressDialog() {
        PriyoLog.d(TAG, "hideProgressDialog()")
        if(progressDialog.isShowing)
            progressDialog.cancel()
    }

    override fun showRationaleDialog(
        titleResId: Int, messageResId: Int, cancelMessageId: Int, iconResId: Int,
        positiveAction: (() -> Unit), negativeAction: (() -> Unit)
    ) {
        AlertDialog.Builder(this, R.style.AppTheme_Dialog)
            .setTitle(titleResId)
            .setIcon(iconResId)
            .setPositiveButton(R.string.text_continue) { _, _ ->
                positiveAction()
                //ActivityCompat.requestPermissions(this, permissionList, permissionRequestCode)
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                negativeAction()
                //Snackbar.make(findViewById(android.R.id.content), cancelMessageId, Snackbar.LENGTH_LONG).show()
            }
            .setCancelable(false)
            .setMessage(messageResId)
            .show()
    }

    override fun showAlertMessage(alertMessageResId: Int, alertType: AlertType) =
        showAlertMessage(android.R.string.dialog_alert_title, alertMessageResId, alertType)

    override fun showAlertMessage(alertMessage: String, alertType: AlertType) {
        showAlertMessage(getString(android.R.string.dialog_alert_title), alertMessage, alertType)
    }

    override fun showAlertMessage(@StringRes alertTitleResId: Int, @StringRes alertMessageResId: Int, alertType: AlertType) {
        showAlertMessage(getString(alertTitleResId), getString(alertMessageResId), alertType)
    }

    override fun showAlertMessage(alertTitle: String?, alertMessage: String, alertType: AlertType) {
        when (alertType) {
            AlertType.Toast -> {
                showShortToast(alertMessage)
            }
            AlertType.Snackbar -> {
                Snackbar.make(findViewById(android.R.id.content), alertMessage, Snackbar.LENGTH_SHORT).show()
            }
            AlertType.Dialog -> {
                AlertDialog.Builder(this)
                    .setTitle(alertTitle)
                    .setCancelable(false)
                    .setPositiveButton(R.string.cancel, null)
                    .setMessage(alertMessage)
                    .create()
                    .show()
            }
        }
    }

    override fun showAlertMessageWithAction(
        alertMessageResId: Int, positiveActionButtonTitleRes: Int,
        negativeActionButtonTitleRes: Int, alertType: AlertType,
        positiveAction: (() -> Unit)?, negativeAction: (() -> Unit)?
    ) {
        showAlertMessageWithAction(
            android.R.string.dialog_alert_title, alertMessageResId, positiveActionButtonTitleRes,
            negativeActionButtonTitleRes, alertType, positiveAction, negativeAction
        )
    }

    override fun showAlertMessageWithAction(
        alertTitleResId: Int, alertMessageResId: Int,
        positiveActionButtonTitleRes: Int, negativeActionButtonTitleRes: Int,
        alertType: AlertType, positiveAction: (() -> Unit)?,
        negativeAction: (() -> Unit)?
    ) {
        showAlertMessageWithAction(
            getString(alertTitleResId), getString(alertMessageResId),
            getString(positiveActionButtonTitleRes), getString(negativeActionButtonTitleRes),
            alertType, positiveAction, negativeAction
        )
    }

    override fun showAlertMessageWithAction(
        alertMessage: String, positiveActionButtonTitle: String,
        negativeActionButtonTitle: String, alertType: AlertType,
        positiveAction: (() -> Unit)?, negativeAction: (() -> Unit)?
    ) {
        showAlertMessageWithAction(
            getString(android.R.string.dialog_alert_title), alertMessage,
            positiveActionButtonTitle, negativeActionButtonTitle,
            alertType, positiveAction, negativeAction
        )
    }

    override fun showAlertMessageWithAction(
        alertTitle: String?, alertMessage: String, positiveActionButtonTitle: String,
        negativeActionButtonTitle: String, alertType: AlertType,
        positiveAction: (() -> Unit)?, negativeAction: (() -> Unit)?
    ) {
        PriyoLog.d(
            TAG, "showAlertMessageWithAction(alertMessage: $alertTitle, alertMessage: $alertMessage, " +
                    "positiveActionButtonTitle: $positiveActionButtonTitle, negativeActionButtonTitle: " +
                    "$negativeActionButtonTitle, alertType: $alertType)"
        )

        when (alertType) {
            AlertType.Toast -> {
                showAlertMessage(alertMessage)
            }
            AlertType.Dialog -> {
                val alertDialogBuilder = AlertDialog.Builder(this)
                    .setTitle(android.R.string.dialog_alert_title)
                    .setCancelable(false)
                    .setMessage(alertMessage)

                if (positiveAction != null) {
                    alertDialogBuilder.setPositiveButton(positiveActionButtonTitle) { _, _ ->
                        positiveAction.invoke()
                    }
                }
                if (negativeAction != null) {
                    alertDialogBuilder.setNegativeButton(negativeActionButtonTitle) { _, _ ->
                        negativeAction.invoke()
                    }
                }
                alertDialogBuilder.create().show()
            }
            AlertType.Snackbar -> {
                val snackbar = Snackbar.make(
                    findViewById(android.R.id.content), alertMessage,
                    Snackbar.LENGTH_INDEFINITE
                )
                if (positiveAction != null) {
                    snackbar.setAction(positiveActionButtonTitle) {
                        positiveAction()
                    }
                }
                snackbar.show()
            }
        }
    }

    override fun onInputError(@IdRes inputId: Int, errorMessageResId: Int) = onInputError(
        inputId,
        getString(errorMessageResId)
    )

    override fun onInputError(@IdRes inputId: Int, errorMessage: String) {
        val errorInput = errorInputArray[inputId] ?: findViewById<View>(inputId)
        when (errorInput) {
            is EditText -> {
                errorInput.error = errorMessage
            }
            is TextInputLayout -> {
                errorInput.error = errorMessage
            }
            is TextInputEditText -> {
                errorInput.error = errorMessage
            }
        }
        errorInput.requestFocus()
        errorInputArray.put(inputId, errorInput)
    }

    override fun clearAllErrors() {
        errorInputArray.forEach { _, errorInput ->
            when (errorInput) {
                is EditText -> {
                    errorInput.error = null
                }
                is TextInputLayout -> {
                    errorInput.error = null
                }
                is TextInputEditText -> {
                    errorInput.error = null
                }
            }
        }
    }
}