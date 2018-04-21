package com.vertx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vertx.entity.ShapeEntity;
/*
 * marks this interface as a Spring Bean which is initialised on application 
 * startup. With this annotation, Spring takes care of managing exception database 
 * interaction throws gracefuly
 */
@Repository
public interface ShapeRepository extends JpaRepository<ShapeEntity, Integer>{

}
