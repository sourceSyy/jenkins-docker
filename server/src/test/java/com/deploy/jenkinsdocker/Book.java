package com.deploy.jenkinsdocker;

import java.time.LocalDate;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class Book {

    private Integer id;

    private String name;

    private Double price;

    private LocalDate publishData;

    // 有参构造
    public Book(Integer id, String name, Double price, LocalDate publishData) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publishData = publishData;
    }

    // SET && GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getPublishData() {
        return publishData;
    }

    public void setPublishData(LocalDate publishData) {
        this.publishData = publishData;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publishData=" + publishData +
                '}';
    }
}

