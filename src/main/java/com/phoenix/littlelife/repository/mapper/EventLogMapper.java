package com.phoenix.littlelife.repository.mapper;

import com.phoenix.littlelife.repository.entity.EventLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 10306
* @description 针对表【event_log】的数据库操作Mapper
* @createDate 2022-12-19 21:53:05
* @Entity com.phoenix.littlelife.repository.entity.EventLog
*/
@Mapper
public interface EventLogMapper extends BaseMapper<EventLog> {

}




