package com.phoenix.littlelife.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.phoenix.littlelife.common.LittleException;
import com.phoenix.littlelife.common.UserContextHolder;
import com.phoenix.littlelife.data.param.BillParam;
import com.phoenix.littlelife.data.param.TagParam;
import com.phoenix.littlelife.data.vo.BillGroupVo;
import com.phoenix.littlelife.repository.entity.BillGroup;
import com.phoenix.littlelife.repository.entity.BillTag;
import com.phoenix.littlelife.repository.mapper.BillGroupMapper;
import com.phoenix.littlelife.repository.mapper.BillTagMapper;
import com.phoenix.littlelife.service.LittleBillService;
import com.phoenix.littlelife.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.phoenix.littlelife.enums.ErrorCodes.TAG_REPEAT;

/**
 * @Author Phoenix Fly
 * @create 2022/7/2 15:24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LittleBillServiceImpl implements LittleBillService {

    private final BillGroupMapper billGroupMapper;

    private final BillTagMapper billTagMapper;

    @Override
    public void createTag(TagParam param) {
        Long userId = UserContextHolder.getUserId();
        //校验库中是否有重复标签
        BillTag oldTag = billTagMapper.selectOne(Wrappers.lambdaQuery(BillTag.class)
                .eq(BillTag::getUserId, userId).eq(BillTag::getName, param.getName()));
        if (Objects.nonNull(oldTag)) {
            throw new LittleException(TAG_REPEAT);
        }
        BillTag billTag = BillTag.builder()
                .id(IdUtils.nextId())
                .userId(userId)
                .name(param.getName())
                .build();
        billTagMapper.insert(billTag);
    }

    @Override
    public List<BillGroupVo> queryBillGroup() {
        // TODO: 2022/7/3 替换id查询方式
        List<BillGroup> groupList = billGroupMapper.selectList(Wrappers.lambdaQuery(BillGroup.class).eq(BillGroup::getUserId, UserContextHolder.getUserId()));
        List<BillGroupVo> voList = new ArrayList<>();
        groupList.forEach(group -> {
            voList.add(BillGroupVo.builder().name(group.getName()).id(group.getId()).build());
        });
        return voList;
    }

    @Override
    public void createBill(BillParam param) {

    }
}
