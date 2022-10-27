package com.phoenix.littlelife.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.phoenix.littlelife.common.LittleException;
import com.phoenix.littlelife.common.UserContextHolder;
import com.phoenix.littlelife.data.param.BillParam;
import com.phoenix.littlelife.data.param.FamilyParam;
import com.phoenix.littlelife.data.param.TagParam;
import com.phoenix.littlelife.data.vo.BillGroupVo;
import com.phoenix.littlelife.repository.entity.BillGroup;
import com.phoenix.littlelife.repository.entity.BillTag;
import com.phoenix.littlelife.repository.entity.Family;
import com.phoenix.littlelife.repository.entity.FamilyUserRelation;
import com.phoenix.littlelife.repository.mapper.BillGroupMapper;
import com.phoenix.littlelife.repository.mapper.BillTagMapper;
import com.phoenix.littlelife.repository.mapper.FamilyMapper;
import com.phoenix.littlelife.repository.mapper.FamilyUserRelationMapper;
import com.phoenix.littlelife.service.LittleBillService;
import com.phoenix.littlelife.utils.AesUtil;
import com.phoenix.littlelife.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    private final FamilyMapper familyMapper;

    private final FamilyUserRelationMapper familyUserRelationMapper;

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

    @Override
    public void createFamily(FamilyParam param) {

        Family family = new Family();
        family.setName(param.getName());
        Long id = IdUtils.nextId();
        family.setId(id);
        family.setCreateTime(LocalDateTime.now());

        familyMapper.insert(family);
        //用户和家庭号绑定
        List<FamilyUserRelation> list = new ArrayList<>();
        param.getUserIds().forEach(v -> {
            list.add(new FamilyUserRelation(IdUtils.nextId(), family.getId(), v));
        });
        familyUserRelationMapper.insertFamilyUserRelation(list);
    }

    @Override
    public void joinFamily(FamilyParam param) {
        // 解密
        String decrypt = AesUtil.decrypt(param.getKey());
        //查询是否已绑定目标家庭id
        //目标家庭id
        long aimFamilyId = Long.parseLong(decrypt);
        //未加入目标家庭的对象
        List<FamilyUserRelation> list = new ArrayList<>();
        //已经加入目标家庭的对象
        List<FamilyUserRelation> relationList = familyUserRelationMapper.selectList(Wrappers.lambdaQuery(FamilyUserRelation.class)
                .eq(FamilyUserRelation::getFamilyId, aimFamilyId)
                .in(FamilyUserRelation::getUserId, param.getUserIds()));
        HashSet<Long> idSet = relationList.stream().map(FamilyUserRelation::getUserId).collect(Collectors.toCollection(HashSet::new));
        param.getUserIds().stream().filter(v -> !idSet.contains(v))
                .forEach(v -> list.add(new FamilyUserRelation(IdUtils.nextId(), aimFamilyId, v)));
//        param.getUserIds().forEach(v -> {
//            FamilyUserRelation familyUserRelation = familyUserRelationMapper.selectOne(Wrappers.lambdaQuery(FamilyUserRelation.class)
//                    .eq(FamilyUserRelation::getFamilyId, aimFamilyId).eq(FamilyUserRelation::getUserId, v)
//            );
//            if (Objects.nonNull(familyUserRelation)) {
//                existsIdList.add(v);
////                throw new LittleException("已经加入该家庭");
//            } else {
//                //添加历史未加入目标家庭的帐号
//                list.add(new FamilyUserRelation(IdUtils.nextId(), aimFamilyId, v));
//            }
//        });
        //用户和家庭号绑定
        if (list.size() != 0) {
            familyUserRelationMapper.insertFamilyUserRelation(list);
        }
        if (idSet.size() != 0) {
            throw new LittleException(idSet + "已经加入该家庭");
        }
    }
}
