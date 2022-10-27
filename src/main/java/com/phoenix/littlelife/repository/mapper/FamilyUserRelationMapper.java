package com.phoenix.littlelife.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phoenix.littlelife.repository.entity.FamilyUserRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.phoenix.littlelife.repository/entity.FamilyUserRelation
 */
@Mapper
public interface FamilyUserRelationMapper extends BaseMapper<FamilyUserRelation> {


    void insertFamilyUserRelation(@Param("param") List<FamilyUserRelation> list);


}




