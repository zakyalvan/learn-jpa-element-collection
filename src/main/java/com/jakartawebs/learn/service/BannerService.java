package com.jakartawebs.learn.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;
import com.mysema.query.types.Predicate;

public interface BannerService {
	Banner createBanner(Collection<Position> positions);
	Banner getBanner(Long id);
	Banner getBanner(Predicate predicate);
	List<Banner> getBanners();
	Iterable<Banner> getBanners(Predicate predicate);
	Page<Banner> getBanners(Pageable pageable, Predicate predicate);
	void removeBanner(Long id);
	void removeBanners(Predicate predicate);
}
