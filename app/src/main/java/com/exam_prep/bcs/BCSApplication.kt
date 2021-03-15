package com.exam_prep.bcs

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import com.exam_prep.bcs.util.*
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.exam_prep.bcs.repository.factory.PriyoRepositoryFactory
import com.exam_prep.bcs.repository.factory.SimplePriyoRepositoryFactory
import com.exam_prep.bcs.util.constant.SharedPreferenceConstants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class BCSApplication : MultiDexApplication(), LifecycleObserver {

    companion object {
        private val TAG = BCSApplication::class.java.simpleName

        lateinit var instance: BCSApplication
            private set
        lateinit var preferences: SharedPreferences
            private set
        lateinit var repositoryFactory: PriyoRepositoryFactory
            private set
        lateinit var googleApiClient: GoogleApiClient
            private set

        private fun logger(): HttpLoggingInterceptor {
            val logger = HttpLoggingInterceptor(HttpLogger())
            logger.level = HttpLoggingInterceptor.Level.BODY
            return logger
        }
        lateinit var disposable: Disposable
        var isAppInBackground = false
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(this);

        // Setting up preferences
        preferences = getSharedPreferences(
            SharedPreferenceConstants.TAG_PRIYO,
            Context.MODE_PRIVATE
        )

        // Singleton Repository Config
        repositoryFactory = SimplePriyoRepositoryFactory.create()

        // GoogleApiClient
        buildGoogleApiClient()
        googleApiClient.connect()
    }

    @Synchronized
    private fun buildGoogleApiClient() {
        googleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks {
                override fun onConnected(p0: Bundle?) {
                    PriyoLog.d(TAG, "GoogleApiClient Connection Successful")
                }

                override fun onConnectionSuspended(p0: Int) {
                    when (p0) {
                        GoogleApiClient.ConnectionCallbacks.CAUSE_NETWORK_LOST -> {
                            PriyoLog.d(
                                TAG,
                                "Network Connection lost with play services. Retrying..."
                            )
                        }
                        GoogleApiClient.ConnectionCallbacks.CAUSE_SERVICE_DISCONNECTED -> {
                            PriyoLog.d(TAG, "Disconnected with play services. Retrying...")
                        }
                    }
                    googleApiClient.connect()
                }

            })
            .addOnConnectionFailedListener {
                PriyoLog.d(TAG, it.errorMessage ?: "Can't Connect to Google Play Services")
                showShortToast("Can't Connect to Google Play Services")
            }
            .addApi(LocationServices.API)
            .build()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        isAppInBackground = false
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        if(SharedPreferenceUtil.getSessionId().isEmpty()) {
            val randomString = (1..13)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");
            SharedPreferenceUtil.setSessionId(randomString)
        }
        if (!SharedPreferenceUtil.getSessionId().isEmpty()) {
            disposable = Observable.interval(
                10, 30,
                TimeUnit.SECONDS
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { aLong: Long? ->
                        callJokesEndpoint(
                            aLong!!
                        )
                    }
                ) {
                }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        isAppInBackground = true
        SharedPreferenceUtil.setSessionId("")
        disposable.dispose()
    }

    @SuppressLint("CheckResult")
    private fun callJokesEndpoint(aLong: Long) {
//        val userInfo = UserInfo()
//        userInfo.email = SharedPreferenceUtil.getUserEmail()
//        userInfo.name = SharedPreferenceUtil.getFirstName()
//        userInfo.userUid = SharedPreferenceUtil.getUUID()
//        userInfo.image = SharedPreferenceUtil.getProfilePictureUrl()
//        val userActivityRequest = UserActivityRequest()
//        userActivityRequest.deviceUid = applicationContext.getDeviceId()
//        userActivityRequest.userId = SharedPreferenceUtil.getUserId()
//        userActivityRequest.sessionId = SharedPreferenceUtil.getSessionId()
//        userActivityRequest.userInfo = userInfo
//        val observable: Observable<GenericResponse> = RetrofitConfig.priyoAnalyticsService.uploadUserActivity(
//            userActivityRequest
//        )
//        observable.subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .map(Function<GenericResponse, Any> { result: GenericResponse -> result.isSuccessful })
//            .subscribe(
//                {
//                }
//            ) { t: Throwable ->
//                handleError(
//                    t
//                )
//            }
    }

    // Launch login page for token timeout/un-authorized/logout called for user inactivity
    fun launchLoginPage() {
        val loggedIn: Boolean = SharedPreferenceUtil.isLoggedIn()
        if (!loggedIn) return
        if (!isAppInBackground) {
            SharedPreferenceUtil.setLoggedIn(false)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                SharedPreferenceUtil.clearAllPreferences();
                clearAppShortCut()
            }
//            val intent = Intent(applicationContext, AppTourActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            startActivity(intent)
        }
    }
}