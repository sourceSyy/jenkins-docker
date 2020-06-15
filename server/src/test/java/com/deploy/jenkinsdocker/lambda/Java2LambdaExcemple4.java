package com.deploy.jenkinsdocker.lambda;

import org.aopalliance.intercept.Joinpoint;

import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
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
public class Java2LambdaExcemple4 {

    public static void main(String[] args) {
        // 顺序计算流 sequential
        // 并行计算流 parallel
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5"); // 指定并行流的线程数
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer max = Stream.iterate(1, x -> x + 1).limit(200).peek((x) -> System.out.println(Thread.currentThread().getName())).parallel().max(Comparator.comparingInt(a -> a)).orElseThrow(() -> new RuntimeException("当前stream流中没有数据"));
        Integer max1 = Stream.iterate(1, x -> x + 1).limit(200).peek((x) -> System.out.println(Thread.currentThread().getName())).parallel().max(Integer::compare).orElseThrow(() -> new RuntimeException("当前stream流中没有数据"));
        System.out.println(max);

    }
}
