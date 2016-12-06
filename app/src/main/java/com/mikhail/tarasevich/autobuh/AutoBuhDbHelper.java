package com.mikhail.tarasevich.autobuh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mikhail on 23.11.2016.
 */

public class AutoBuhDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = AutoBuhDbHelper.class.getSimpleName();

    /**
     * Имя файла базы данных
     */
    private static final String DATABASE_NAME = "autobuh.db";

    /**
     * Версия базы данных. При изменении схемы увеличить на единицу
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Конструктор {@link AutoBuhDbHelper}.
     *
     * @param context Контекст приложения
     */
    public AutoBuhDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Вызывается при создании базы данных
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE " + AutoBuhDatabase.GuestEntry.TABLE_NAME + " ("
                + AutoBuhDatabase.GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AutoBuhDatabase.GuestEntry.COLUMN_DATE + " TEXT NOT NULL, "
                + AutoBuhDatabase.GuestEntry.COLUMN_MILEAGE + " INTEGER NOT NULL, "
                + AutoBuhDatabase.GuestEntry.COLUMN_SUM + " REAL NOT NULL, "
                + AutoBuhDatabase.GuestEntry.COLUMN_SUM_CURRENCY_ID + " TEXT NOT NULL, "
                + AutoBuhDatabase.GuestEntry.COLUMN_NOTES + ", "
                + AutoBuhDatabase.GuestEntry.COLUMN_EXPENDITURE_ID + " TEXT NOT NULL;";

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    /**
     * Вызывается при обновлении схемы базы данных
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_NAME);
        // Создаём новую таблицу
        onCreate(db);
    }
}
