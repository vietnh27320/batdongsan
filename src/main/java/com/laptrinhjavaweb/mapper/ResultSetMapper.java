package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper<T> {
    public List<T> mapRow(ResultSet rs, Class<T> zClass) {
        List<T> results = new ArrayList<>();
        try {
            if (zClass.isAnnotationPresent(Entity.class)) {
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                Field[] fields = zClass.getDeclaredFields();
                while (rs.next()) {
                    T object = zClass.newInstance();
                    for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                        String columnName = resultSetMetaData.getColumnName(i + 1);
                        Object columnValue = rs.getObject(i + 1);
                        for (Field field : fields) {
                            if (field.isAnnotationPresent(Column.class)) {
                                Column column = field.getAnnotation(Column.class);
                                if (column.name().equals(columnName) && columnValue != null) {
                                    // set gia tri
                                    BeanUtils.setProperty(object, field.getName(), columnValue);
                                    break;
                                }
                            }
                        }
                    }
                    results.add(object);
                }
            }
            return results;
        } catch (Exception exception) {
            return null;
        }
    }
}
