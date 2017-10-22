package com.cinovation.web.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.treatment.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
