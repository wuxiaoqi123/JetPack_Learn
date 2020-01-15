package com.welcome.jetpack_learn.ui.other

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.just.agentweb.AgentWeb
import com.just.agentweb.AgentWebSettingsImpl
import com.just.agentweb.DefaultWebClient
import com.welcome.jetpack_learn.R
import com.welcome.jetpack_learn.ext.setLightMode
import com.welcome.jetpack_learn.ext.setupToolBar
import com.welcome.jetpack_learn.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_web.*
import widget.CoolIndicatorLayout

class CommonWebActivity : AppCompatActivity() {

    private lateinit var mUrl: String
    private lateinit var mTitle: String
    private lateinit var mAgentWeb: AgentWeb

    companion object {
        fun loadUrl(context: Context, url: String, title: String) {
            val intent = Intent(context, CommonWebActivity::class.java)
            intent.putExtra("url", url)
            intent.putExtra("title", title)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        setLightMode()
        getIntentData()
        initWebView()
        initToolBar()
        menuClick()
    }

    private fun getIntentData() {
        if (intent != null) {
            mTitle = intent.getStringExtra("title")
            mUrl = intent.getStringExtra("url")
        }
    }

    private fun initWebView() {
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(ll_common_web, LinearLayout.LayoutParams(-1, -1))
            .setCustomIndicator(CoolIndicatorLayout(this))
            .setAgentWebWebSettings(AgentWebSettingsImpl.getInstance())
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .interceptUnkownUrl()
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
            .createAgentWeb()
            .go(mUrl)
    }

    private fun initToolBar() {
        setupToolBar(toolbar) {
            setDisplayHomeAsUpEnabled(true)
            title = mTitle
        }
    }

    private fun menuClick() {
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_share -> CommonUtils.share(this@CommonWebActivity, mUrl)
                R.id.menu_open -> CommonUtils.openBrowser(this@CommonWebActivity, mUrl)
                else -> false
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.article_detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        mAgentWeb.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }
}