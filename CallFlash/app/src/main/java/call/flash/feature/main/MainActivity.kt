package call.flash.feature.main

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import call.flash.common.extension.getStatusBarHeight
import call.flash.common.extension.startFlashLight
import call.flash.common.extension.startLed
import call.flash.common.extension.startRingtone
import call.flash.databinding.ActivityMainBinding
import com.basic.common.base.LsActivity
import com.basic.common.extension.clicks
import com.basic.common.extension.getDimens
import com.basic.common.extension.transparent
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class MainActivity : LsActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparent()
        setContentView(binding.root)

        initView()
        initObservable()
        initData()
        listenerView()
    }

    private fun listenerView() {
        val onOffsetChangedListener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val alpha = 1 - abs(verticalOffset).toFloat() / getDimens(com.intuit.sdp.R.dimen._100sdp)
            binding.switchButton.alpha = alpha
            binding.textSwitch.alpha = alpha
        }
        binding.appBar.addOnOffsetChangedListener(onOffsetChangedListener)

        binding.switchButton.setOnCheckedChangeListener { _, isChecked -> binding.viewTurnOnFlash.isVisible = isChecked }
        binding.menu.setOnClickListener { binding.drawerLayout.openDrawer(GravityCompat.START) }
        binding.drawerSetting.viewRingtone.clicks(withAnim = false) { startRingtone() }
        binding.drawerSetting.viewLed.clicks(withAnim = false) { startLed() }
        binding.callFlash.clicks { startFlashLight() }
    }

    private fun initData() {

    }

    private fun initObservable() {

    }

    private fun initView() {
        binding.viewTop.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            this.topMargin = when(val statusBarHeight = getStatusBarHeight()) {
                0 -> getDimens(com.intuit.sdp.R.dimen._30sdp).toInt()
                else -> statusBarHeight
            }
        }
    }

    @Deprecated("Deprecated in Java", ReplaceWith("finish()"))
    override fun onBackPressed() {
        finish()
    }

}