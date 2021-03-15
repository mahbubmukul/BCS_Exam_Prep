@file:Suppress("DEPRECATION", "unused")

package com.exam_prep.bcs.util

import android.app.Activity
import android.app.Fragment
import android.app.ProgressDialog
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import androidx.fragment.app.Fragment as SupportFragment

fun <V : View> View.bindView(@IdRes id: Int)
        : ReadOnlyProperty<View, V> = required(id, viewFinder)

fun <V : View> Activity.bindView(@IdRes id: Int)
        : ReadOnlyProperty<Activity, V> = required(id, viewFinder)

fun <V : View> Fragment.bindView(@IdRes id: Int)
        : ReadOnlyProperty<Fragment, V> = required(id, viewFinder)

fun <V : View> androidx.fragment.app.Fragment.bindView(@IdRes id: Int)
        : ReadOnlyProperty<androidx.fragment.app.Fragment, V> = required(id, viewFinder)

fun <V : View> RecyclerView.ViewHolder.bindView(@IdRes id: Int)
        : ReadOnlyProperty<RecyclerView.ViewHolder, V> = required(id, viewFinder)

fun createProgressDialog()
        : ReadOnlyProperty<Activity, ProgressDialog> = required(progressDialogCreator)

fun Fragment.createProgressDialog()
        : ReadOnlyProperty<Fragment, ProgressDialog> = required(progressDialogCreator)

fun SupportFragment.createProgressDialog()
        : ReadOnlyProperty<SupportFragment, ProgressDialog> = required(progressDialogCreator)

private val progressDialogCreator: Activity.() -> ProgressDialog?
    get() = { ProgressDialog(this) }

private val Fragment.progressDialogCreator: Fragment.() -> ProgressDialog?
    get() = { ProgressDialog(this.activity) }

private val SupportFragment.progressDialogCreator: SupportFragment.() -> ProgressDialog?
    get() = { ProgressDialog(this.activity) }

private val View.viewFinder: View.(Int) -> View?
    get() = { findViewById(it) }

private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }

private val Fragment.viewFinder: Fragment.(Int) -> View?
    get() = { view!!.findViewById(it) }

private val androidx.fragment.app.Fragment.viewFinder: androidx.fragment.app.Fragment.(Int) -> View?
    get() = { view!!.findViewById(it) }

private val RecyclerView.ViewHolder.viewFinder: RecyclerView.ViewHolder.(Int) -> View?
    get() = { itemView.findViewById(it) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(id: Int, finder: T.(Int) -> View?) = Lazy { t: T, desc ->
    t.finder(id) as V? ?: viewNotFound(id, desc)
}

@Suppress("UNCHECKED_CAST")
private fun <T> required(finder: T.() -> ProgressDialog?) = Lazy { t: T, desc ->
    t.finder() ?: cantCreateProgressDialog(desc)
}

private fun cantCreateProgressDialog(desc: KProperty<*>): Nothing =
    throw IllegalStateException("Can't create progress dialog for '${desc.name}'")

private fun viewNotFound(id: Int, desc: KProperty<*>): Nothing =
    throw IllegalStateException("View ID $id for '${desc.name}' not found.")

private class Lazy<in T, out V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private object EMPTY

    private var value: Any? = EMPTY

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }
}