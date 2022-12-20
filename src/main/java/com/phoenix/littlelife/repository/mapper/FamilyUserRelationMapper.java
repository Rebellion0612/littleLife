package com.phoenix.littlelife.repository.mapper;

import com.phoenix.littlelife.repository.entity.FamilyUserRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 10306
* @description 针对表【family_user_relation】的数据库操作Mapper
* @createDate 2022-12-19 22:11:05
* @Entity com.phoenix.littlelife.repository.entity.FamilyUserRelation
*/
public interface FamilyUserRelationMapper extends BaseMapper<FamilyUserRelation> {
    void insertFamilyUserRelation(@Param("param")List<FamilyUserRelation> list);

}




