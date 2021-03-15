package com.exam_prep.bcs.customview

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LifecycleObserver
import com.exam_prep.bcs.R


class CenteredTitleToolbar: Toolbar, LifecycleObserver {

    companion object {
        private val TAG = CenteredTitleToolbar::class.java
    }

    private var _titleTextView: TextView? = null
    private var _screenWidth = 0
    private var _centerTitle = true

    constructor(context: Context) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, androidx.appcompat.R.attr.toolbarStyle)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr)

    init{
        _screenWidth = getScreenSize()!!.x
        _titleTextView = TextView(context)
        _titleTextView!!.setTextAppearance(context, R.style.ToolbarTitleText)
        _titleTextView!!.text = "Title"
        addView(_titleTextView)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (_centerTitle) {
            val location = IntArray(2)
            _titleTextView!!.getLocationOnScreen(location)
            _titleTextView!!.translationX =
                _titleTextView!!.translationX + (-location[0] + _screenWidth / 2 - _titleTextView!!.width / 2)
        }
    }

    override fun setTitle(title: CharSequence?) {
        _titleTextView!!.text = title
        requestLayout()
    }

    override fun setTitle(titleRes: Int) {
        _titleTextView!!.setText(titleRes)
        requestLayout()
    }

    fun setTitleCentered(centered: Boolean) {
        _centerTitle = centered
        requestLayout()
    }

    private fun getScreenSize(): Point? {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val screenSize = Point()
        display.getSize(screenSize)
        return screenSize
    }
}