@file:Suppress("DEPRECATION")

package com.exam_prep.bcs.viewmodel.listener

import android.app.ProgressDialog
import androidx.annotation.StringRes

interface ProgressDialogListener {
	val progressDialog: ProgressDialog
	fun showProgressDialog(@StringRes resId: Int, isCancelable: Boolean)
	fun showProgressDialog(message: String, isCancelable: Boolean)
	fun hideProgressDialog()

}