package com.flow.extension.util;

import java.util.HashMap;

import org.springframework.jdbc.support.JdbcUtils;

public class ParamMap extends HashMap { 

    @SuppressWarnings("unchecked")
    public Object put(Object key, Object value) { 
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key), value); 
    } 
}

