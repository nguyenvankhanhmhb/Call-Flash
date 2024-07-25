package call.flash.common.extension

import android.app.Activity
import android.content.Intent
import call.flash.feature.flashlight.FlashlightActivity
import call.flash.feature.led.LedActivity
import call.flash.feature.main.MainActivity
import call.flash.feature.phone.PhoneActivity
import call.flash.feature.ringtone.RingtoneActivity

fun Activity.startMain(){
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
}

fun Activity.startLed(){
    val intent = Intent(this, LedActivity::class.java)
    startActivity(intent)
}

fun Activity.startRingtone(){
    val intent = Intent(this, RingtoneActivity::class.java)
    startActivity(intent)
}

fun Activity.startFlashLight(){
    val intent = Intent(this, FlashlightActivity::class.java)
    startActivity(intent)
}

fun Activity.startPhone(){
    val intent = Intent(this, PhoneActivity::class.java)
    startActivity(intent)
}