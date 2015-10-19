package com.countrytable.model;

import com.countrytable.database.DataBaseUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = DataBaseUtils.COUNTRY_TABLE)
public class Country extends AbstractModel {

    private static final String BUNDLE_KEY = "country";

    @JsonProperty("city_name")
    @DatabaseField(columnName = DataBaseUtils.COUNTRY_NAME, dataType = DataType.STRING)
    private String cityName;

    @JsonProperty("city_api_url")
    @DatabaseField(columnName = DataBaseUtils.CITY_URL, dataType = DataType.STRING)
    private String cityApiUrl;

    @JsonProperty("city_domain")
    @DatabaseField(columnName = DataBaseUtils.CITY_DOMIAN, dataType = DataType.STRING)
    private String cityDomain;

    @JsonProperty("city_mobile_server")
    @DatabaseField(columnName = DataBaseUtils.CITY_MOBILE_SERVER, dataType = DataType.STRING)
    private String cityMobileServer;

    @JsonProperty("city_doc_url")
    @DatabaseField(columnName = DataBaseUtils.CITY_DOC_URL, dataType = DataType.STRING)
    private String cityDocUrl;

    @JsonProperty("city_latitude")
    @DatabaseField(columnName = DataBaseUtils.CITY_LAT, dataType = DataType.DOUBLE)
    private double cityLatitude;

    @JsonProperty("city_longitude")
    @DatabaseField(columnName = DataBaseUtils.CITY_LON, dataType = DataType.DOUBLE)
    private double cityLongitude;

    @JsonProperty("city_spn_latitude")
    @DatabaseField(columnName = DataBaseUtils.CITY_SPN_LAT, dataType = DataType.DOUBLE)
    private double citySpnLatitude;

    @JsonProperty("city_spn_longitude")
    @DatabaseField(columnName = DataBaseUtils.CITY_SPN_LON, dataType = DataType.DOUBLE)
    private double citySpnLongitude;

    @JsonProperty("last_app_android_version")
    @DatabaseField(columnName = DataBaseUtils.LAST_APP_VER, dataType = DataType.INTEGER)
    private int lastAppAndroidVersion;

    @JsonProperty("android_driver_apk_link")
    @DatabaseField(columnName = DataBaseUtils.DRIVER_APK_LINK, dataType = DataType.STRING)
    private String androidDriverApkLink;

    @JsonProperty("inapp_pay_methods")
    private String[] inappPayMethods;

    @JsonProperty("transfers")
    @DatabaseField(columnName = DataBaseUtils.TRANSFERS, dataType = DataType.BOOLEAN)
    private boolean transfers;


    @JsonProperty("experimental_econom_plus")
    @DatabaseField(columnName = DataBaseUtils.ECONOM_PLUS, dataType = DataType.INTEGER)
    private int experimentalEconomPlus;


    @JsonProperty("experimental_econom_plus_time")
    @DatabaseField(columnName = DataBaseUtils.ECONOM_PLUS_TIME, dataType = DataType.INTEGER)
    private int experimentalEconomPlusTime;


    @JsonProperty("registration_promocode")
    @DatabaseField(columnName = DataBaseUtils.PROMOCODE, dataType = DataType.BOOLEAN)
    private boolean registrationPromocode;


    public String getCityName() {
        return cityName;
    }

    public String getCityApiUrl() {
        return cityApiUrl;
    }

    public String getCityDomain() {
        return cityDomain;
    }

    public String getCityMobileServer() {
        return cityMobileServer;
    }

    public String getCityDocUrl() {
        return cityDocUrl;
    }

    public double getCityLatitude() {
        return cityLatitude;
    }

    public double getCityLongitude() {
        return cityLongitude;
    }

    public double getCitySpnLatitude() {
        return citySpnLatitude;
    }

    public double getCitySpnLongitude() {
        return citySpnLongitude;
    }

    public int getLastAppAndroidVersion() {
        return lastAppAndroidVersion;
    }

    public String getAndroidDriverApkLink() {
        return androidDriverApkLink;
    }

    public String[] getInappPayMethods() {
        return inappPayMethods;
    }

    public boolean isTransfers() {
        return transfers;
    }

    public int getExperimentalEconomPlus() {
        return experimentalEconomPlus;
    }

    public int getExperimentalEconomPlusTime() {
        return experimentalEconomPlusTime;
    }

    public boolean isRegistrationPromocode() {
        return registrationPromocode;
    }

    @Override
    protected String getBundleKey() {
        return BUNDLE_KEY;
    }
}
