package com.flow.extension.service;

import java.util.Map;

public interface ExtensionService {
    public Map<String,Object> selectExtensionList() throws Exception;
    public Map<String,Object> updateFixExtension(Map<String,Object> param) throws Exception;
    public Map<String,Object> deleteCustomExtension(Map<String,Object> param) throws Exception;
    public Map<String,Object> insertCustomExtension(Map<String,Object> param) throws Exception;
}
