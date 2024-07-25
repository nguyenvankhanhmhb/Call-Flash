package call.flash.feature.splash

import android.annotation.SuppressLint
import android.os.Bundle
import call.flash.common.extension.startMain
import call.flash.databinding.ActivitySplashBinding
import com.basic.common.base.LsActivity
import com.basic.common.extension.transparent
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : LsActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparent()
        setContentView(binding.root)

        initView()
        initObservable()
        initData()
    }


    private fun initData() {

    }

    private fun initObservable() {

    }

    private fun initView() {
        binding.viewIcon
            .animate()
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(1000)
            .withEndAction {
                binding.textAppName
                    .animate()
                    .alpha(1f)
                    .setDuration(1000)
                    .setStartDelay(500)
                    .withEndAction {
                        startMain()
                        finish()
                    }
                    .start()
            }
            .setStartDelay(500)
            .start()
    }

    @Deprecated("Deprecated in Java", ReplaceWith("finish()"))
    override fun onBackPressed() {
        finish()
    }

}