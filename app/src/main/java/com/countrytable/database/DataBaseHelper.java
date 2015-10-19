package com.countrytable.database;

import android.database.sqlite.SQLiteDatabase;

import com.countrytable.TheApplication;
import com.countrytable.model.AbstractModel;
import com.countrytable.model.Country;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    public DataBaseHelper() {
        super(TheApplication.getInstance(), DataBaseUtils.DATABASE_NAME, null, DataBaseUtils.DATABASE_VERSION);
    }

    private static final List<Class<? extends AbstractModel>> tablesClasses = new ArrayList<Class<? extends AbstractModel>>() {
        {
            add(Country.class);
        }
    };

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        for (Class<? extends AbstractModel> tablesClass : tablesClasses) {
            try {
                TableUtils.createTable(connectionSource, tablesClass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        for (Class<? extends AbstractModel> tablesClass : tablesClasses) {
            try {
                TableUtils.dropTable(connectionSource, tablesClass, true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        onCreate(sqLiteDatabase, connectionSource);
    }
}
