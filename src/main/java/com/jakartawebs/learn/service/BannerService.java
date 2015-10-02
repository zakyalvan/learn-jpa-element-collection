package com.jakartawebs.learn.service;

import java.util.Collection;
import java.util.List;

import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;

public interface BannerService {
	Banner createBanner(Collection<Position> positions);
	List<Banner> getBanners();
}
