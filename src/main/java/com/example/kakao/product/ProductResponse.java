package com.example.kakao.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer productId;
        private String productName;
        private String image;
        private Integer price;
        private int currentPage = 1; // 현재 페이지
        private int pageSize = 9; // 페이지당 아이템 수

        public FindAllDTO(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();

        }

    }

    // (기능2) 상품 상세보기
    @Getter
    @Setter
    public static class FindByIdDTO {

    }
}