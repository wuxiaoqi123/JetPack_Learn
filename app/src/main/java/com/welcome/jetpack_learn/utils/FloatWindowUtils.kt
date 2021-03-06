package com.welcome.jetpack_learn.utils

import android.app.Application
import android.util.Log
import android.view.animation.BounceInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.welcome.jetpack_learn.MainActivity
import com.welcome.jetpack_learn.R
import com.yhao.floatwindow.*

object FloatWindowUtils {

    private const val TAG = "FloatWindowUtils"

    fun init(application: Application) {
        FloatWindow
            .with(application)
            .setView(R.layout.layout_float_view)
            .setWidth(Screen.width, 0.7f)
            .setHeight(Screen.height, 0.3f)
            .setX(Screen.width, 0.3f)
            .setY(Screen.height, 0.45f)
            .setMoveType(MoveType.slide, 0, 0)
            .setMoveStyle(500, BounceInterpolator())
            .setDesktopShow(true)
            .setFilter(true, MainActivity::class.java)
            .setPermissionListener(mPermissionListener)
            .setViewStateListener(mViewStateListener)
            .build()
        val view = FloatWindow.get().view
        val ll = view.findViewById<LinearLayout>(R.id.ll_flow_content)
        view.findViewById<AppCompatButton>(R.id.btn_float_close).setOnClickListener { destory() }
        view.findViewById<AppCompatButton>(R.id.btn_float_clear).setOnClickListener {
            ll.removeAllViews()
        }
    }

    fun isShow(): Boolean = FloatWindow.get().isShowing

    fun show() {
        if (FloatWindow.get() != null && !FloatWindow.get().isShowing) {
            FloatWindow.get().show()
        }
    }

    fun hide() {
        if (FloatWindow.get() != null && FloatWindow.get().isShowing) {
            FloatWindow.get().hide()
        }
    }

    fun destory() {
        if (FloatWindow.get() != null) {
            FloatWindow.destroy()
        }
    }

    fun addViewContent(msg: String) {
        if (FloatWindow.get() == null) return
        val view = FloatWindow.get().view
        val ll = view.findViewById<LinearLayout>(R.id.ll_flow_content)
        val tv = TextView(view.context)
        tv.text = msg
        ll.addView(tv)
    }

    fun clear() {
        if (FloatWindow.get() == null) return
        val view = FloatWindow.get().view
        val ll = view.findViewById<LinearLayout>(R.id.ll_flow_content)
        ll.removeAllViews()
    }

    private val mPermissionListener = object : PermissionListener {
        override fun onSuccess() {
            Log.d(TAG, "onSuccess")
        }

        override fun onFail() {
            Log.d(TAG, "onFail")
        }
    }

    private val mViewStateListener = object : ViewStateListener {
        override fun onPositionUpdate(x: Int, y: Int) {
            Log.d(TAG, "onPositionUpdate: x=$x y=$y")
        }

        override fun onShow() {
            Log.d(TAG, "onShow")
        }

        override fun onHide() {
            Log.d(TAG, "onHide")
        }

        override fun onDismiss() {
            Log.d(TAG, "onDismiss")
        }

        override fun onMoveAnimStart() {
            Log.d(TAG, "onMoveAnimStart")
        }

        override fun onMoveAnimEnd() {
            Log.d(TAG, "onMoveAnimEnd")
        }

        override fun onBackToDesktop() {
            Log.d(TAG, "onBackToDesktop")
        }
    }
}

