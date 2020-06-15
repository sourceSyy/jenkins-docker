package com.deploy.jenkinsdocker.lambda;

import lombok.Getter;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
@Getter
public enum ProductStatus {

    UP(1, "下架"),
    DOWN(0, "上架");

    private int code;

    private String message;

    ProductStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
