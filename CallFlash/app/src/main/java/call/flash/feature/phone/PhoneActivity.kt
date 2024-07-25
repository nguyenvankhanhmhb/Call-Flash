package call.flash.feature.phone

import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import call.flash.common.extension.getStatusBarHeight
import call.flash.common.extension.startMain
import call.flash.databinding.ActivityFlashLightBinding
import call.flash.databinding.ActivityLedBinding
import call.flash.databinding.ActivityPhoneBinding
import com.basic.common.base.LsActivity
import com.basic.common.extension.clicks
import com.basic.common.extension.getDimens
import com.basic.common.extension.transparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhoneActivity : LsActivity<ActivityPhoneBinding>(ActivityPhoneBinding::inflate) {

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

    }

    private fun initData() {

    }

    private fun initObservable() {

    }

    private fun initView() {

    }

    @Deprecated("Deprecated in Java", ReplaceWith("finish()"))
    override fun onBackPressed() {
        finish()
    }

}