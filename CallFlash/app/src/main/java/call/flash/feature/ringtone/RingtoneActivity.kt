package call.flash.feature.ringtone

import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import call.flash.common.extension.getStatusBarHeight
import call.flash.databinding.ActivityLedBinding
import call.flash.databinding.ActivityRingtoneBinding
import com.basic.common.base.LsActivity
import com.basic.common.extension.clicks
import com.basic.common.extension.getDimens
import com.basic.common.extension.transparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RingtoneActivity : LsActivity<ActivityRingtoneBinding>(ActivityRingtoneBinding::inflate) {

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
        binding.back.clicks { onBackPressed() }
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