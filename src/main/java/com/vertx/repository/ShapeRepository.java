package com.vertx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vertx.entity.ShapeEntity;

public interface ShapeRepository extends JpaRepository<ShapeEntity, Long>{

}
