package jcaselles.bdoprofitcalculator.ui.bosses

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import jcaselles.bdoprofitcalculator.R

class BossesBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val text = intent.extras?.getInt(BossesViewModel.BOSS_TEXT, 0)

        val builder = NotificationCompat.Builder(context, context.getString(R.string.app_name))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(context.getString(R.string.notifaction_boss_title))
            .setContentText("Boss in $text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = System.currentTimeMillis() / 1000

        notificationManager.notify(id.toInt(), builder.build())
    }
}