package com.wearebrain.ake.sample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.wearebrain.ake.context.*
import com.wearebrain.ake.resources.dp
import com.wearebrain.ake.resources.px
import com.wearebrain.ake.string.*
import com.wearebrain.ake.view.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val services = arrayOf(
        Context.WINDOW_SERVICE,
        Context.LAYOUT_INFLATER_SERVICE,
        Context.ACTIVITY_SERVICE,
        Context.POWER_SERVICE,
        Context.ALARM_SERVICE,
        Context.NOTIFICATION_SERVICE,
        Context.KEYGUARD_SERVICE,
        Context.LOCATION_SERVICE,
        Context.SEARCH_SERVICE,
        Context.SENSOR_SERVICE,
        Context.STORAGE_SERVICE,
        Context.VIBRATOR_SERVICE,
        Context.CONNECTIVITY_SERVICE,
        Context.WIFI_SERVICE,
        Context.AUDIO_SERVICE,
        Context.MEDIA_ROUTER_SERVICE,
        Context.TELEPHONY_SERVICE,
        Context.TELEPHONY_SUBSCRIPTION_SERVICE,
        Context.CARRIER_CONFIG_SERVICE,
        Context.INPUT_METHOD_SERVICE,
        Context.UI_MODE_SERVICE,
        Context.DOWNLOAD_SERVICE,
        Context.BATTERY_SERVICE,
        Context.JOB_SCHEDULER_SERVICE,
        Context.NETWORK_STATS_SERVICE,
        Context.HARDWARE_PROPERTIES_SERVICE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Context extensions

        btnResourceExtensions.setOnClickListener {
            if (networkAvailable()) {
                showToast("Network available")
            } else if (networkUnavailable()) {
                showToast("Network unavailable")
            }

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select service")
            builder.setItems(services) { _, which ->
                val serviceName = services[which]

                when (serviceName) {
                    Context.WINDOW_SERVICE -> showToast("Your service: ${windowService()}")
                    Context.LAYOUT_INFLATER_SERVICE -> showToast("Your service: ${layoutInflaterService()}")
                    Context.ACTIVITY_SERVICE -> showToast("Your service: ${activityService()}")
                    Context.POWER_SERVICE -> showToast("Your service: ${powerService()}")
                    Context.ALARM_SERVICE -> showToast("Your service: ${alarmService()}")
                    Context.NOTIFICATION_SERVICE -> showToast("Your service: ${notificationService()}")
                    Context.KEYGUARD_SERVICE -> showToast("Your service: ${keyguardService()}")
                    Context.LOCATION_SERVICE -> showToast("Your service: ${locationService()}")
                    Context.SEARCH_SERVICE -> showToast("Your service: ${searchService()}")
                    Context.SENSOR_SERVICE -> showToast("Your service: ${sensorService()}")
                    Context.STORAGE_SERVICE -> showToast("Your service: ${storageService()}")
                    Context.VIBRATOR_SERVICE -> showToast("Your service: ${vibratorService()}")
                    Context.CONNECTIVITY_SERVICE -> showToast("Your service: ${connectivityService()}")
                    Context.WIFI_SERVICE -> showToast("Your service: ${wifiService()}")
                    Context.AUDIO_SERVICE -> showToast("Your service: ${audioService()}")
                    Context.MEDIA_ROUTER_SERVICE -> showToast("Your service: ${mediaRouterService()}")
                    Context.TELEPHONY_SERVICE -> showToast("Your service: ${telephonyService()}")
                    Context.TELEPHONY_SUBSCRIPTION_SERVICE -> showToast("Your service: ${telephonySubscriptionService()}")
                    Context.CARRIER_CONFIG_SERVICE -> showToast("Your service: ${carrierConfigService()}")
                    Context.INPUT_METHOD_SERVICE -> showToast("Your service: ${inputMethodService()}")
                    Context.UI_MODE_SERVICE -> showToast("Your service: ${uiModeService()}")
                    Context.DOWNLOAD_SERVICE -> showToast("Your service: ${downloadService()}")
                    Context.BATTERY_SERVICE -> showToast("Your service: ${batteryService()}")
                    Context.JOB_SCHEDULER_SERVICE -> showToast("Your service: ${jobSchedulerService()}")
                    Context.NETWORK_STATS_SERVICE -> showToast("Your service: ${networkStatsService()}")
                    Context.HARDWARE_PROPERTIES_SERVICE -> showToast("Your service: ${hardwarePropertiesService()}")
                }
            }
            builder.show()
        }

        // Context extensions

        // Resources extensions

        btnResourceExtensions.setOnClickListener {
            showToast(
                "10 px = ${10.dp} dp"
                        + "10 dp = ${10.px} px"
                        + "10.5 px = ${10.5f.dp} dp"
                        + "10.5 dp = ${10.5f.px} px"
            )
        }

        // Resources extensions

        // String extensions

        val htmlText = "\n\n<html>\n" +
                "<body background=\"bgimage.jpg\">\n" +
                "<h1>Hello world!</h1>\n" +
                "<p><a href=\"https://www.w3schools.com\">Visit W3Schools.com!</a></p>\n" +
                "</body>\n" +
                "</html>\n\n"

        val validWebUrl = "https://www.google.com"
        val invalidWebUrl = "https//www.google.com"

        val validPhone = "+123456789123"
        val invalidPhone = "+1234567890a"

        val validEmail = "email@email.com"
        val invalidEmail = "email@email"

        btnStringExtensions.setOnClickListener {
            showToast(
                "Empty string -> `${String.EMPTY}`\n" +
                        "White space string -> `${String.WHITESPACE}`\n" +
                        "Html text -> `$htmlText`\n" +
                        "After clearing -> ${htmlText.clearHtmlTags()}\n" +
                        "Is valid web url -> `$validWebUrl` is valid -> ${validWebUrl.isValidWebUrl()}\n" +
                        "Is valid web url -> `$invalidWebUrl` is valid -> ${invalidWebUrl.isValidWebUrl()}\n" +
                        "Is valid phone -> `$validPhone` is valid -> ${validPhone.isValidPhoneNumber()}\n" +
                        "Is valid phone -> `$invalidPhone` is valid -> ${invalidPhone.isValidPhoneNumber()}\n" +
                        "Is valid email -> `$validEmail` is valid -> ${validEmail.isValidEmail()}\n" +
                        "Is valid email -> `$invalidEmail` is valid -> ${invalidEmail.isValidEmail()}\n"
            )
        }

        // String extension

        // Compound button extensions

        cb.onCheckedChange { showToast("Checked -> $it") }
        cbUnchecked.onChecked { showToast("Checked!") }
        cbChecked.onUnChecked { showToast("Unchecked!") }

        // Compound button extensions

        // Text view extensions

        btnShowKeyboard.setOnClickListener { et.showKeyboard() }
        btnShowKeyboardDelayed.setOnClickListener { et.showKeyboardDelayed(1000) }
        btnHideKeyboard.setOnClickListener { et.hideKeyboard() }
        btnHideKeyboardDelayed.setOnClickListener { et.hideKeyboardDelayed(1000) }

        // Text view extensions
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
