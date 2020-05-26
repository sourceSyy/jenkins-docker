package com.deploy.jenkinsdocker;

import java.time.LocalDate;
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
public class Java8LambdaExcemple3 {


    /**
     * Java8 经典实战案例整理
     */
    public static void main(String[] args) {
        // 经典拆分案例一将字符串参数拆分为map
        String str = "key=value&name=zhangsan&age=25&sex=1&mobile=15123432343";
        Stream<String[]> stream = Stream.of(str.split("&")).map(s -> s.split("="));
        Map<String, String> collect = stream.collect(Collectors.toMap((xs) -> xs[0], (xs) -> xs[1]));
        System.out.println(collect);

        // 经典实战案例二 提取book中价格大于70数据的bookID
        List<Integer> collect1 = books().stream().filter(book -> book.getPrice() >= 70).map(Book::getId).collect(Collectors.toList());
        System.out.println(collect1);

        // 经典实战案例二 提取book中价格大于70数据的bookID 并将ID 组装成为string
        String bookIds = books().stream().filter(book -> book.getPrice() >= 70).map(book -> book.getId()+"").collect(Collectors.joining(",", "(", ")"));
        System.out.println(bookIds);

        // 经典实战案例三 按照price排序然后输出内容
        books().stream().sorted(Comparator.comparingDouble(Book::getPrice)).collect(Collectors.toList()).forEach(System.out::println);

        // 经典实战案例四 首先按照price排序然后如果price相同则按照publishDate排序
        books().stream().sorted(Comparator.comparingDouble(Book::getPrice).reversed().thenComparing(Book::getPublishData)).forEach(System.out::println);

        // 经典实战案例五 将list转换为map 然后输出
        Map<Integer, Book> collect2 = books().stream().collect(Collectors.toMap(Book::getId, book -> book));
        collect2.keySet().forEach((key) -> System.out.println(collect2.get(key)));

        // 经典实战案例六 求price平均数
        Double collect3 = books().stream().collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println(collect3);

        OptionalDouble average = books().stream().mapToDouble(Book::getPrice).average();
        System.out.println(average.getAsDouble());

        // 经典实战案例七
        Map<Double, List<Book>> collect4 = books().stream().collect(Collectors.groupingBy(Book::getPrice));
        collect4.keySet().forEach(System.out::println);

        // 经典实战案例八

        // 经典实战案例九

        // 经典实战案例十

        // 经典实战案例十一

        // 经典实战案例十二

        // 经典实战案例十三

        // 经典实战案例十四

        // 经典实战案例十五




    }


    static List<Book> books(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "python", 50d, LocalDate.parse("2011-04-28")));
        books.add(new Book(2, "java", 60d, LocalDate.parse("2011-04-29")));
        books.add(new Book(3, "tomcat", 66d, LocalDate.parse("2011-10-12")));
        books.add(new Book(4, "NGINX", 66d, LocalDate.parse("2011-09-12")));
        books.add(new Book(5, "SPRING", 70d, LocalDate.parse("2011-08-12")));
        books.add(new Book(6, "HADOOP", 72d, LocalDate.parse("2011-07-12")));
        books.add(new Book(7, "算法导论", 75d, LocalDate.parse("2011-04-12")));
        books.add(new Book(8, "大话设计模式", 80d, LocalDate.parse("2019-04-12")));
        books.add(new Book(9, "jetty", 90d, LocalDate.parse("2018-04-12")));
        books.add(new Book(10, "mongo", 91d, LocalDate.parse("2011-04-12")));
        books.add(new Book(11, "oracle", 72d, LocalDate.parse("2017-04-12")));
        books.add(new Book(12, "mysql", 80d, LocalDate.parse("2011-06-12")));
        books.add(new Book(13, "postgres", 82d, LocalDate.parse("2014-04-12")));
        books.add(new Book(14, "redis", 56d, LocalDate.parse("2015-04-12")));
        books.add(new Book(15, "sql 入门到精通", 59d, LocalDate.parse("2011-04-16")));
        return books;
    }




}
