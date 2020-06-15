package com.deploy.jenkinsdocker.lambda;

import java.util.Optional;
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
public class Java8LambdaExcemple5 {

    //reduce 操作 聚合
    public static void main(String[] args) {

        Optional<Integer> reduce = Stream.of(10, 20, 25, 20, 21, 22, 4, 10).reduce((n1, n2) -> n1 - n2);

        Integer reduce1 = Stream.of(10, 20, 25, 20, 21, 22, 4, 10).reduce(1, (n1, n2) -> n1 + n2);

        Integer reduce2 = Stream.of(10, 20, 25, 20, 21, 22, 4, 10).reduce(1, (n1, n2) -> n1 - n2, (n1, n2) -> n1 - n2);


        System.out.println(reduce);
        System.out.println(reduce1);
        System.out.println(reduce2);


    }

}
