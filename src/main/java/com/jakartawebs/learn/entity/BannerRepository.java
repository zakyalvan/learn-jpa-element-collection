package com.jakartawebs.learn.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BannerRepository extends JpaRepository<Banner, Long>, QueryDslPredicateExecutor<Banner> {

}
