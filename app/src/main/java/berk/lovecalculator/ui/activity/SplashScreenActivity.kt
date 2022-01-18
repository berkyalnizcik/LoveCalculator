package berk.lovecalculator.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import berk.lovecalculator.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        if (haveNetwork()) {
            Handler(mainLooper).postDelayed({
                Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(this)
                    finish()
                }
            }, 3000L)
        } else {
            val builder = AlertDialog.Builder(this@SplashScreenActivity)
            builder.setTitle("Love Calculator")
            builder.setMessage("Internet Not Found!")
            builder.setNegativeButton("Exit") { dialogInterface, i -> finish() }
            builder.setPositiveButton("Try Again") { dialogInterface, i -> restartApp() }
            builder.show()
        }
    }

    private fun haveNetwork(): Boolean {
        var haveWifi = false
        var haveMobile = false
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfos = connectivityManager.allNetworkInfo
        for (info in networkInfos) {
            if (info.typeName.equals("WIFI", ignoreCase = true)) if (info.isConnected) haveWifi =
                true
            if (info.typeName.equals(
                    "MOBILE",
                    ignoreCase = true
                )
            ) if (info.isConnected) haveMobile = true
        }
        return haveMobile || haveWifi
    }

    private fun restartApp() {
        startActivity(Intent(applicationContext, SplashScreenActivity::class.java))
        finish()
    }
}