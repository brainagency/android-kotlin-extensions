package com.wearebrain.kotlinandroidextensions

import android.annotation.TargetApi
import android.app.*
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.content.Context
import android.hardware.SensorManager
import android.location.LocationManager
import android.media.MediaRouter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.*
import android.os.storage.StorageManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Returns WindowManager
 *
 * @return instance of WindowManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.WINDOW_SERVICE
 */
fun Context.windowService() =
    getService<WindowManager>(Context.WINDOW_SERVICE)

/**
 * Returns LayoutInflater
 *
 * @return instance of LayoutInflater
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.LAYOUT_INFLATER_SERVICE
 */
fun Context.layoutInflaterService() =
    getService<LayoutInflater>(Context.LAYOUT_INFLATER_SERVICE)

/**
 * Returns ActivityManager
 *
 * @return instance of ActivityManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.ACTIVITY_SERVICE
 */
fun Context.activityService() =
    getService<ActivityManager>(Context.ACTIVITY_SERVICE)

/**
 * Returns PowerManager
 *
 * @return instance of PowerManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.POWER_SERVICE
 */
fun Context.powerSerice() =
    getService<PowerManager>(Context.POWER_SERVICE)

/**
 * Returns AlarmManager
 *
 * @return instance of AlarmManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.ALARM_SERVICE
 */
fun Context.alarmService() =
    getService<AlarmManager>(Context.ALARM_SERVICE)

/**
 * Returns NotificationManager
 *
 * @return instance of NotificationManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.NOTIFICATION_SERVICE
 */
fun Context.notificationSEevice() =
    getService<NotificationManager>(Context.NOTIFICATION_SERVICE)

/**
 * Returns KeyguardManager
 *
 * @return instance of KeyguardManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.KEYGUARD_SERVICE
 */
fun Context.keyguardService() =
    getService<KeyguardManager>(Context.KEYGUARD_SERVICE)

/**
 * Returns LocationManager
 *
 * @return instance of LocationManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.LOCATION_SERVICE
 */
fun Context.locationService() =
    getService<LocationManager>(Context.LOCATION_SERVICE)

/**
 * Returns StorageManager
 *
 * @return instance of StorageManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.STORAGE_SERVICE
 */
fun Context.storageService() =
    getService<StorageManager>(Context.STORAGE_SERVICE)

/**
 * Returns SensorManager
 *
 * @return instance of SensorManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.SENSOR_SERVICE
 */
fun Context.sensorService() =
    getService<SensorManager>(Context.SENSOR_SERVICE)

/**
 * Returns Vibrator
 *
 * @return instance of Vibrator
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.VIBRATOR_SERVICE
 */
fun Context.vibratorService() =
    getService<Vibrator>(Context.VIBRATOR_SERVICE)

/**
 * Returns ConnectivityManager
 *
 * @return instance of ConnectivityManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.CONNECTIVITY_SERVICE
 */
fun Context.connectivityService() =
    getService<ConnectivityManager>(Context.CONNECTIVITY_SERVICE)

/**
 * Returns WifiManager
 *
 * @return instance of WifiManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.WIFI_SERVICE
 */
fun Context.wifiService() =
    getService<WifiManager>(Context.WIFI_SERVICE)

/**
 * Returns MediaRouter
 *
 * @return instance of MediaRouter
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.MEDIA_ROUTER_SERVICE
 */
fun Context.mediaRouterService() =
    getService<MediaRouter>(Context.MEDIA_ROUTER_SERVICE)

/**
 * Returns TelephonyManager
 *
 * @return instance of TelephonyManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.TELEPHONY_SERVICE
 */
fun Context.telephonyService() =
    getService<TelephonyManager>(Context.TELEPHONY_SERVICE)

/**
 * Returns SubscriptionManager
 *
 * @return instance of SubscriptionManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.TELEPHONY_SUBSCRIPTION_SERVICE
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
fun Context.telephonySubscriptionService() =
    getService<SubscriptionManager>(Context.TELEPHONY_SUBSCRIPTION_SERVICE)

/**
 * Returns CarrierConfigManager
 *
 * @return instance of CarrierConfigManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.CARRIER_CONFIG_SERVICE
 */
@TargetApi(Build.VERSION_CODES.M)
fun Context.carrierConfigService() =
    getService<CarrierConfigManager>(Context.CARRIER_CONFIG_SERVICE)

/**
 * Returns InputMethodManager
 *
 * @return instance of InputMethodManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.INPUT_METHOD_SERVICE
 */
fun Context.inputMethodService() =
    getService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)

/**
 * Returns UiModeManager
 *
 * @return instance of UiModeManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.UI_MODE_SERVICE
 */
fun Context.uiModeService() =
    getService<UiModeManager>(Context.UI_MODE_SERVICE)

/**
 * Returns DownloadManager
 *
 * @return instance of DownloadManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.DOWNLOAD_SERVICE
 */
fun Context.downloadService() =
    getService<DownloadManager>(Context.DOWNLOAD_SERVICE)

/**
 * Returns BatteryManager
 *
 * @return instance of BatteryManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.BATTERY_SERVICE
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.batteryService() =
    getService<BatteryManager>(Context.BATTERY_SERVICE)

/**
 * Returns JobScheduler
 *
 * @return instance of JobScheduler
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.JOB_SCHEDULER_SERVICE
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.jobSchedulerService() =
    getService<JobScheduler>(Context.JOB_SCHEDULER_SERVICE)

/**
 * Returns NetworkStatsManager
 *
 * @return instance of NetworkStatsManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.NETWORK_STATS_SERVICE
 */
@TargetApi(Build.VERSION_CODES.M)
fun Context.networkStatsService() =
    getService<NetworkStatsManager>(Context.NETWORK_STATS_SERVICE)

/**
 * Returns HardwarePropertiesManager
 *
 * @return instance of HardwarePropertiesManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.HARDWARE_PROPERTIES_SERVICE
 */
@TargetApi(Build.VERSION_CODES.N)
fun Context.hardwarePropertiesService() =
    getService<HardwarePropertiesManager>(Context.HARDWARE_PROPERTIES_SERVICE)

/**
 * Returns class representing service with provided name
 *
 * @param[name] - name of the needed service
 *
 * @return instance of HardwarePropertiesManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 */
private inline fun <reified T> Context.getService(name: String): T = getSystemService(name) as T

