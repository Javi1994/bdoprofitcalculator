package jcaselles.bdoprofitcalculator.ui.bosses

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import jcaselles.bdoprofitcalculator.model.Bosses
import jcaselles.bdoprofitcalculator.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject

class BossesViewModel @Inject constructor(private val app: Application) : BaseViewModel() {
    companion object {
        val BOSS_TEXT = "boss_text"
    }

    private fun setupAlarm(calendar: Calendar) {
        val alarmManager = app.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val bundle = Bundle()
        bundle.putInt(BOSS_TEXT, calendar.get(Calendar.MINUTE))

        val broadcastIntent = Intent(app.applicationContext, BossesBroadcastReceiver::class.java)
        broadcastIntent.putExtras(bundle)

        val id = System.currentTimeMillis().toInt()
        val alarmIntent = PendingIntent.getBroadcast(app.applicationContext, id, broadcastIntent, 0)

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
    }

    fun initializeBossAlarms() {
        for (calendar in Bosses.KARANDA.getBossSchedule()) {
            setupAlarm(calendar)
        }
    }
}