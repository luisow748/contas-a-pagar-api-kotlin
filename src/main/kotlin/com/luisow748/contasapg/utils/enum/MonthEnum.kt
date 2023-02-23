package com.luisow748.contasapg.utils.enum

enum class MonthEnum(val id: String,
                     val nameOfMonth: String) {
    JANUARY("1", "january"),
    FEBUARY("2", "febuary"),
    MARCH("3", "march"),
    APRIL("4", "april"),
    MAY("5", "may"),
    JUNE("6", "june"),
    JULY("7", "july"),
    AUGUST("8", "august"),
    SEPTEMBER("9", "september"),
    OCTOBER("10", "october"),
    NOVEMBER("11", "november"),
    DECEMBER("12", "december");

    companion object {
        fun getMonthNameById(id: String): String{
            val toInt = id.toInt().dec()
            return MonthEnum.values()[toInt].nameOfMonth
        }
    }
}


