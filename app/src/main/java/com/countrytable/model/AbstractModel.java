package com.countrytable.model;

import android.os.Bundle;

import com.countrytable.database.DataBaseUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("city_id")
    @DatabaseField(id = true, canBeNull = false, dataType = DataType.INTEGER, columnName = DataBaseUtils.ID)
    private int id;

    public AbstractModel(AbstractModel abstractModel) {
    }

    protected AbstractModel() {
    }

    public int getId() {
        return id;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putSerializable(getBundleKey(), this);
        return b;
    }

    protected abstract String getBundleKey();

}
