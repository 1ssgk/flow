package com.flow.extension.service;

import java.util.Map;

import com.google.common.collect.Maps;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.MapUtils;

@Service
@Transactional
public class ExtensionServiceImpl implements ExtensionService {

    @Autowired
    private SqlSession sqlSession;

    protected static final String NAMESPACE = "extensionMapper.";
    
    @Override
    public Map<String, Object> selectExtensionList() throws Exception {
        // TODO Auto-generated method stub
        
        Map<String,Object> resultMap = Maps.newHashMap();

        resultMap.put("fix", sqlSession.selectList(NAMESPACE + "selectFixExtensionList"));
        resultMap.put("cus", sqlSession.selectList(NAMESPACE + "selectCustomExtensionList"));
        resultMap.put("cnt", sqlSession.selectOne(NAMESPACE + "selectCustomExtensionCount"));

        return resultMap;
    }

    @Override
    public Map<String, Object> updateFixExtension( Map<String,Object> param) throws Exception {
        // TODO Auto-generated method stub

        if( !MapUtils.isEmpty(param) ){
            sqlSession.update(NAMESPACE + "updateFixExtension",param);
        }

        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap = this.selectExtensionList();

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteCustomExtension(Map<String, Object> param) throws Exception {
        // TODO Auto-generated method stub

        if( !MapUtils.isEmpty(param) ){
            sqlSession.delete(NAMESPACE + "deleteCustomExtension",param);
        }

        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap = this.selectExtensionList();

        return resultMap;
    }

    @Override
    public Map<String, Object> insertCustomExtension(Map<String, Object> param) throws Exception {
        // TODO Auto-generated method stub

        if( !MapUtils.isEmpty(param) ){

            Map<String,Object> existData = sqlSession.selectOne(NAMESPACE + "existCustomExtensionName",param);
            Map<String,Object> paramMap = Maps.newHashMap();

            if( !MapUtils.isEmpty(existData) ){
                paramMap = existData;
            }else{
                paramMap = param;
            }

            sqlSession.insert(NAMESPACE + "insertCustomExtension",paramMap);
        }

        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap = this.selectExtensionList();

        return resultMap;
    }

}
