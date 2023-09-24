package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(List<Cart> cartList) {
            this.totalPrice = cartList.stream()
                    .mapToInt(t -> t.getPrice())
                    .sum();
            this.products = cartList.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(product, cartList))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer productId;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> carts) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.carts = carts.stream()
                //.filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                .map(c -> new CartDTO(c))
                .collect(Collectors.toList());
            }

            @Getter
            @Setter
            public class CartDTO {
                private Integer cartId;
                private String optionName;
                private Integer quantity;
                private Integer cartPrice;

                public CartDTO(Cart cart) {
                    this.cartId = cart.getId();
                    this.optionName = cart.getOption().getOptionName();
                    this.quantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                }

                

            }
        }
    }
}
