package com.flow.extension.controller;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.extension.service.ExtensionService;
import com.google.common.collect.Maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/extension")
public class ExtensionController {
    
    @Autowired
    private ExtensionService extensionService;

    @GetMapping("/data")
    public Map<String,Object> selectExtensionList() throws Exception{
        
        return extensionService.selectExtensionList();
    }

    @PutMapping
    public Map<String,Object> updateFixExtension(@RequestBody String param) throws Exception{
        
        Map<String, Object> result = Maps.newHashMap();
        ObjectMapper mapper = new ObjectMapper();

        if( !param.isEmpty() ){
            Map<String, Object> paramMap = mapper.readValue(param, new TypeReference<Map<String, Object>>() {});
            
            result = extensionService.updateFixExtension(paramMap);
        }

        return result;
    }

    @DeleteMapping("/{no}")
    public Map<String,Object> deleteCustomExtension(@RequestBody String param,@PathVariable("no") Integer no) throws Exception{

        Map<String, Object> result = Maps.newHashMap();
        ObjectMapper mapper = new ObjectMapper();

        if( !param.isEmpty() ){
            Map<String, Object> paramMap = mapper.readValue(param, new TypeReference<Map<String, Object>>() {});

            result = extensionService.deleteCustomExtension(paramMap);
        }

        return result;
    }
    
    @PostMapping("/{name}")
    public Map<String,Object> insertCustomExtension(@PathVariable("name") String name) throws Exception{

        Map<String, Object> result = Maps.newHashMap();

        if( name !=null ){
            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("name", name);

            result = extensionService.insertCustomExtension(paramMap);
        }

        return result;
    }
    
}
