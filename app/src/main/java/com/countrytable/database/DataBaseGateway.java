package com.countrytable.database;

import android.util.Log;

import com.countrytable.database.dao.CommonDao;
import com.countrytable.model.Country;

import java.sql.SQLException;
import java.util.List;

public class DataBaseGateway {
    private static final String TAG = DataBaseGateway.class.getSimpleName();
    private static DataBaseGateway Instance;
    private DataBaseHelper databaseHelper = new DataBaseHelper();
    /**
     * Countries calls
     */
    private CommonDao<Country> countryCommonDao;

    public static DataBaseGateway getInstance() {
        if (Instance == null) {
            Instance = new DataBaseGateway();
        }
        return Instance;
    }

    private CommonDao<Country> getCountryDao() throws SQLException {
        if (countryCommonDao == null) {
            countryCommonDao = new CommonDao<Country>(databaseHelper.getConnectionSource(), Country.class);
        }
        return countryCommonDao;
    }

    public void clearCountries() {
        try {
            getCountryDao().removeAll();
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void saveCountries(List<Country> countries) {
        try {
            for (Country country : countries) {
                getCountryDao().createOrUpdate(country);
            }
        } catch (SQLException e) {
            Log.e(TAG, "saveCountries", e);
        }
    }
}
