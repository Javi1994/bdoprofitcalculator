package jcaselles.bdoprofitcalculator.model

import java.util.*

enum class Bosses {
    KARANDA(),
    KZARKA(),
    KUTUM(),
    NOUVER(),
    VELL();

    fun getBossSchedule(): MutableList<Calendar> {
        return when (this) {
            KARANDA -> getKarandaSchedule()
            KZARKA -> getKzarkaSchedule()
            KUTUM -> getKutumSchedule()
            NOUVER -> getNouverSchedule()
            VELL -> getVellSchedule()
        }
    }

    private fun getKarandaSchedule(): MutableList<Calendar> {
        val schedule = mutableListOf<Calendar>()

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 14)
            set(Calendar.MINUTE, 0)
        })

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 14)
            set(Calendar.MINUTE, 1)
        })

        return schedule
    }

    private fun getKzarkaSchedule(): MutableList<Calendar> {
        val schedule = mutableListOf<Calendar>()

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 24)
            set(Calendar.MINUTE, 0)
        })

        return schedule
    }

    private fun getKutumSchedule(): MutableList<Calendar> {
        val schedule = mutableListOf<Calendar>()

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 24)
            set(Calendar.MINUTE, 0)
        })

        return schedule
    }

    private fun getNouverSchedule(): MutableList<Calendar> {
        val schedule = mutableListOf<Calendar>()

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 24)
            set(Calendar.MINUTE, 0)
        })

        return schedule
    }

    private fun getVellSchedule(): MutableList<Calendar> {
        val schedule = mutableListOf<Calendar>()

        schedule.add(Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, 6)
            set(Calendar.HOUR_OF_DAY, 24)
            set(Calendar.MINUTE, 0)
        })

        return schedule
    }
}