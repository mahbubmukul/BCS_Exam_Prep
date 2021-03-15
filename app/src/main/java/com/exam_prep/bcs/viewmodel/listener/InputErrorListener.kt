package com.exam_prep.bcs.viewmodel.listener

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import android.util.SparseArray
import android.view.View

interface InputErrorListener {
	val errorInputArray: SparseArray<View>
	fun onInputError(@IdRes inputId: Int, @StringRes errorMessageResId: Int)
	fun onInputError(@IdRes inputId: Int, errorMessage: String)
	fun clearAllErrors()
}