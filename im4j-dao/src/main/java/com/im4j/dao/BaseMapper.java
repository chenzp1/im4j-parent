package com.im4j.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenzp on 2017/7/26 0026.
 */
public interface BaseMapper <P,E>{
    int countByExample(E example);

    int deleteByExample(E example);

    int insert(P record);

    int insertSelective(P record);

    List<P> selectByExample(E example);

    int updateByExampleSelective(@Param("record") P record, @Param("example") E example);

    int updateByExample(@Param("record") P record, @Param("example") E example);
}
