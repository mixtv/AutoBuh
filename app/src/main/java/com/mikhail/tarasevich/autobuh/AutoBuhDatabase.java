package com.mikhail.tarasevich.autobuh;

/**
 * Created by Mikhail on 23.11.2016.
 */
import android.provider.BaseColumns;

public final class AutoBuhDatabase {

    public static final class GuestEntry implements BaseColumns {
        public final static String TABLE_NAME = "EXPENDITURES";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "DATE"; // дата
        public final static String COLUMN_EXPENDITURE_ID = "EXPENDITURE_ID"; // ID статьи расходов
        public final static String COLUMN_MILEAGE = "MILEAGE"; // Пробег
        public final static String COLUMN_NOTES = "NOTES"; // Примечания
        public final static String COLUMN_SUM = "SUM"; // сумма
        public final static String COLUMN_SUM_CURRENCY_ID = "SUM_CURRENCY_ID"; // ID валюты
    }
}
