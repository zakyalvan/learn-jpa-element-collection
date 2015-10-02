package com.jakartawebs.learn.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jakartawebs.learn.LearningApplication;
import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;
import com.jakartawebs.learn.entity.BannerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=LearningApplication.class)
@Transactional
public class BannerServiceTest {
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private BannerRepository bannerRepository;
	
	@Before
	public void preloadBanners() {
		List<Position> positions = Arrays.asList(Position.HOME);
		bannerService.createBanner(positions);
	}
	
	@Test
	public void testCreateBanner() {
		List<Position> positions = Arrays.asList(Position.HOME, Position.BENEFIT);
		bannerService.createBanner(positions);
		Assert.isTrue(bannerRepository.count() == 2);
	}
	
	@Test
	public void testRetrieveBanners() {
		List<Banner> banners = bannerService.getBanners();
		Assert.isTrue(banners.size() == 1);
	}
}
