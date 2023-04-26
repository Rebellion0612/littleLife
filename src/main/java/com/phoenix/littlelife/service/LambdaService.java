package com.phoenix.littlelife.service;

import com.google.api.client.util.Lists;
import com.phoenix.littlelife.repository.entity.Bill;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhangpengfei
 * @create 2023/4/26
 */
public class LambdaService {
    public static void main(String[] args) {
        List<Bill> billList = Lists.newArrayList();
        // groupBy用法  id为key  金额 为 value， 如果出现重复key  取先前的
        Map<Long, Long> billAmountMap = billList.stream().collect(Collectors.toMap(Bill::getId, Bill::getAmount, (a, b) -> a));
        // id为key  Bill对象为value，  如果出现重复key， 取之后的
        Map<Long, Bill> billMap = billList.stream().collect(Collectors.toMap(Bill::getId, Function.identity(), (a, b) -> b));
        //两个获取set 结果一样，但是数据结构不一样，使用 hashSet  contains方法可以更快，以hash值定位
        Set<Long> groupSet = billList.stream().map(Bill::getGroupId).collect(Collectors.toSet());
        HashSet<Long> groupSet2 = billList.stream().map(Bill::getGroupId).collect(Collectors.toCollection(HashSet::new));
        // 这个list经过去重，结果跟上边的set一样， map 中 可以用代码，亦可以用lambda表达式的写法  distinct去重
        List<Long> groupList = billList.stream().map(v -> v.getGroupId()).distinct().collect(Collectors.toList());
        //这个是统计次数 统计金额大于1000 的条数
        long count = billList.stream().map(Bill::getAmount).filter(v -> v > 1000).count();

        //这个是获取  groupBy groupId这个字段， value 是所有同一个groupId的 bill的 list集合
        Map<Long, List<Bill>> groupBillMap = billList.stream().collect(Collectors.groupingBy(Bill::getGroupId));

        //这个是 按照一个方法去排序， 获取一个排序后的集合，（原集合不受影响），  排序方法可自定义， 返回一个 int值，如果为正 v1 排在前边，如果为负，v1排在后边
        List<Bill> sortList = billList.stream().sorted((v1, v2) -> {
            if (v1.getAmount() > 0) {
                return (int) (v1.getAmount() - v2.getAmount());
            } else {
                return (int) (v2.getAmount() - v1.getAmount());
            }
        }).collect(Collectors.toList());

        // 此处是获取 第一个 金额大于 2000的订单
        Optional<Bill> first = billList.stream().filter(v -> v.getAmount() > 2000).findFirst();
        // 如果 first.isPresent() 是 true 则证明找到了 该订单，如果是false， 则未找到
        if (first.isPresent()) {
            Bill bill = first.get();
        }

        //效果同上 判断条件不一致
        Optional<Bill> any = billList.stream().filter(v -> v.getGroupId() == 1 && v.getId() == 2).findAny();
        if (any.isPresent()) {
            Bill bill = any.get();
        }

        //遍历0-9，每次步增 + 1   limit是指遍历次数
        Stream.iterate(0, s -> s + 1)
                .limit(10)
                .forEach(s -> {
                    System.out.println(s);
                });

        //数组用stream 要先转换为 list
        int[] arr = new int[]{1, 2, 3};
        Arrays.asList(arr).stream().forEach(System.out::print);

    }
}
