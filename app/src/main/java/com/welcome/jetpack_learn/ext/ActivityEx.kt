package com.welcome.jetpack_learn.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.app.ViewModelFactory
import com.welcome.jetpack_learn.utils.StatusBarUtil


fun FragmentActivity.snackBarShow(view: View?, str: String) {
    view?.let { Snackbar.make(it, str, Snackbar.LENGTH_SHORT).show() }
}


fun FragmentActivity.clipTxt(txt: String) {
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val mClipData = ClipData.newPlainText("Label", txt)
    cm.setPrimaryClip(mClipData)
}

fun AppCompatActivity.setLightMode() {
    StatusBarUtil.setLightMode(this)
}

fun AppCompatActivity.setupToolBar(toolbar: Toolbar, action: ActionBar.() -> Unit) {
    toolbar.setTitleTextColor(resources.getColor(R.color.black))
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        action()
    }
}

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, application?.let { ViewModelFactory.getInstance(it) }).get(
        viewModelClass
    )