package com.example.kakao.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;

    // (기능1) 상품 목록보기
    public List<ProductResponse.FindAllDTO> findAll(int page) {

        List<ProductResponse.FindAllDTO> dtos = new ArrayList<>();
        List<Product> productList = productJPARepository.findAll();

        dtos = productList.stream()
                .map(p -> new ProductResponse.FindAllDTO(p))
                .collect(Collectors.toList());

        return dtos;
    }

    // (기능2) 상품 상세보기
    public ProductResponse.FindByIdDTO findById(int id) {
        return null;
    }
}
