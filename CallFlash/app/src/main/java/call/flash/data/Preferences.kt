package call.flash.data

import com.f2prateek.rx.preferences2.RxSharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(
    private val rxPrefs: RxSharedPreferences
) {

    companion object {

    }

}
