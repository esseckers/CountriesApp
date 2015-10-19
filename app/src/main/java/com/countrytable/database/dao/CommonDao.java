package com.countrytable.database.dao;

import com.countrytable.database.DataBaseUtils;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class CommonDao<T> extends BaseDaoImpl<T, String> {

    public CommonDao(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public T get(String id) throws SQLException {
        QueryBuilder<T, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(DataBaseUtils.ID, id);
        List<T> result = query(queryBuilder.prepare());
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public void removeAll() throws SQLException {
        delete(deleteBuilder().prepare());
    }
}
