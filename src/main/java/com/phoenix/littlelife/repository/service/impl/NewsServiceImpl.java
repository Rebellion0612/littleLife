package com.phoenix.littlelife.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phoenix.littlelife.repository.entity.News;
import com.phoenix.littlelife.service.NewsService;
import com.phoenix.littlelife.repository.mapper.NewsMapper;
import org.springframework.stereotype.Service;

/**
* @author 10306
* @description 针对表【news】的数据库操作Service实现
* @createDate 2023-05-10 16:23:13
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

}




