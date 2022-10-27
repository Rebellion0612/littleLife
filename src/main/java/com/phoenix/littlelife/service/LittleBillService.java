package com.phoenix.littlelife.service;

import com.phoenix.littlelife.data.param.BillParam;
import com.phoenix.littlelife.data.param.FamilyParam;
import com.phoenix.littlelife.data.param.TagParam;
import com.phoenix.littlelife.data.vo.BillGroupVo;

import java.util.List;

/**
 * @Author Phoenix Fly
 * @create 2022/7/2 15:24
 */
public interface LittleBillService {

    /**
     * 创建标签
     *
     * @param param 标签参数
     */
    void createTag(TagParam param);

    /**
     * 创建账单
     *
     * @param param 账单参数
     */
    void createBill(BillParam param);

    /**
     * 查询账单分组
     *
     * @return 全部的账单分组
     */
    List<BillGroupVo> queryBillGroup();

    /**
     * 创建家庭
     *
     * @param param 家庭参数
     */
    void createFamily(FamilyParam param);

    /**
     * 加入家庭
     *
     * @param param
     */
    void joinFamily(FamilyParam param);

}
