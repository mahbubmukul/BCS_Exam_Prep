package com.exam_prep.bcs.viewmodel.listener

import androidx.annotation.StringRes
import com.exam_prep.bcs.viewmodel.listener.AlertType

interface AlertMessageListener {

    fun showRationaleDialog(titleResId: Int, messageResId: Int, cancelMessageId: Int, iconResId: Int,
                            positiveAction: (() -> Unit), negativeAction: (() -> Unit))

    fun showAlertMessage(@StringRes alertMessageResId: Int, alertType: AlertType = AlertType.Toast)
    fun showAlertMessage(alertMessage: String, alertType: AlertType = AlertType.Toast)

    fun showAlertMessage(@StringRes alertTitleResId: Int, @StringRes alertMessageResId: Int, alertType: AlertType = AlertType.Toast)
    fun showAlertMessage(alertTitle: String?, alertMessage: String, alertType: AlertType = AlertType.Toast)

    fun showAlertMessageWithAction(@StringRes alertMessageResId: Int,
                                   @StringRes positiveActionButtonTitleRes: Int,
                                   @StringRes negativeActionButtonTitleRes: Int,
                                   alertType: AlertType = AlertType.Toast, positiveAction: (() -> Unit)? = null, negativeAction: (() -> Unit)? = null)

    fun showAlertMessageWithAction(alertMessage: String,
                                   positiveActionButtonTitle: String,
                                   negativeActionButtonTitle: String,
                                   alertType: AlertType = AlertType.Toast, positiveAction: (() -> Unit)? = null, negativeAction: (() -> Unit)? = null)

    fun showAlertMessageWithAction(@StringRes alertTitleResId: Int,
                                   @StringRes alertMessageResId: Int,
                                   @StringRes positiveActionButtonTitleRes: Int,
                                   @StringRes negativeActionButtonTitleRes: Int,
                                   alertType: AlertType = AlertType.Toast, positiveAction: (() -> Unit)? = null, negativeAction: (() -> Unit)? = null)

    fun showAlertMessageWithAction(alertTitle: String?,
                                   alertMessage: String,
                                   positiveActionButtonTitle: String,
                                   negativeActionButtonTitle: String,
                                   alertType: AlertType = AlertType.Toast, positiveAction: (() -> Unit)? = null, negativeAction: (() -> Unit)? = null)
}

