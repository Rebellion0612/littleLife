package com.phoenix.littlelife.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phoenix.littlelife.repository.entity.Family;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.phoenix.littlelife.repository/entity.Family
 */
//
@Mapper
public interface FamilyMapper extends BaseMapper<Family> {

    void insertFamily(@Param("param") Family family);

}




