package com.deploy.jenkinsdocker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class Java8LambdaExceple2 {

    /**
     * Stream 的四种创建方式
     * 最常用前两种方式
     */
    public void gen1 (){
        Stream<String> stringStream = Stream.of("aa", "bb", "cc", "dd");
    }
    public void gen2(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }
    public void gen3(){
        Stream<Integer> generate = Stream.generate(() -> 1);
    }
    public void gen4(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
    }


    public static void main(String[] args) {

        //filter 过滤数组中所有的偶数
        Stream.of(1, 2, 3, 4, 5).filter(x -> x%2 == 0).forEach(System.out::println);

        //过滤数组中所有的偶数，并且求和
        int sum = Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        //过滤数组中所有偶数，并且得出最大值
        OptionalInt max1 = Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).mapToInt(x -> x).max();
        System.out.println(max1.getAsInt());

        //过滤数组中所有偶数，并且得出最小值
        Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).min(Comparator.comparingInt(a -> a)).orElseThrow(
                () -> new RuntimeException("找不到当前数据"));

        //过滤数组中所有偶数，并且得出平均值
        Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).mapToInt(x -> x).average().orElseThrow(
                () -> new RuntimeException("查找不到当前数据"));

        //得出count值
        long count = Stream.of(1, 2, 3, 4, 5, 6).count();
        System.out.println(count);

        // findAny 排序后 查找任意一个
        int any = Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x%2 == 0).sorted().findAny().orElseThrow(
                () -> new RuntimeException("查找不到参数"));
        System.out.println(any);

        // findFirst 排序后 查找第一个
        Integer first = Stream.of(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).sorted((a, b) -> b - a).findFirst().orElseThrow(
                () -> new RuntimeException("查找不到参数"));
        System.out.println(first);

        //anyMatch
        boolean anyMatch = Stream.of(1, 2, 3, 4, 5, 6).anyMatch(a -> a < 0);
        System.out.println(anyMatch);

        //allMatch
        boolean allMatch = Stream.of(1, 2, 3, 4, 5, 6).allMatch(a -> a < 3);
        System.out.println(allMatch);

        //noneMatch
        boolean b = Stream.of(1, 2, 3, 4, 5, 6).noneMatch(a -> a < 3);
        System.out.println(b);

        //map 类型转换 将Integer 转换为 String
        List<String> collect = Stream.of(1, 2, 3, 4, 5, 6).map(Object::toString).collect(Collectors.toList());

        //map 类型转换 将String 转换为 User1 类型
        List<User1> user1Stream = Stream.of("admin", "root", "user1", "user2", "user3", "user4").map(User1::new).collect(Collectors.toList());
        System.out.println(user1Stream);

        //map 类型转换 String 转换Integer 类型
        List<Integer> collect1 = Stream.of("admin", "root", "user1", "user2", "user3", "user4").map(String::length).collect(Collectors.toList());
        System.out.println(collect1);

        //list TO map
        Map<byte[], String> collect2 = Stream.of("admin", "root", "user1", "user2", "user3", "user4").collect(Collectors.toMap(x -> x.getBytes(), x -> x));
        System.out.println(collect2);

        // limit skip 合作使用， 首先构建  达到分页的效果
        Stream<Integer> limit = Stream.iterate(1, x -> x + 1).limit(50);
        limit.skip(0).limit(10).forEach(System.out::println);

        //peek 可以在构建过程中，记录日志
        Integer max = Stream.iterate(1, x -> x + 1).limit(50).peek(System.out::println).max(Comparator.comparingInt(a -> a)).orElseThrow(
                () -> new RuntimeException("查找不到参数"));
        System.out.println(max);

        //去除重复
        List<Integer> collect3 = Stream.of(1, 2, 3, 4, 5, 1, 3, 5).distinct().collect(Collectors.toList());
        System.out.println(collect3);

    }
}

class User1{

    private String name;

    public User1(String name) {
        this.name = name;
    }

    public User1() {

    }
}