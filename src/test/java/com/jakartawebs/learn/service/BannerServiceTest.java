package com.jakartawebs.learn.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.jakartawebs.learn.entity.BannerRepository;
import com.jakartawebs.learn.LearningApplication;
import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=LearningApplication.class)
public class BannerServiceTest {
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private BannerRepository bannerRepository;
	
	@Before
	public void initBanners() {
		List<Position> positions = Arrays.asList(Position.HOME);
		bannerService.createBanner(positions);
	}
	
	@Test
	public void testCreateBanner() {
		List<Position> positions = Arrays.asList(Position.HOME, Position.BENEFIT);
		bannerService.createBanner(positions);
		Assert.isTrue(bannerRepository.count() == 1);
	}
	
	@Test
	public void testRetrieveBanners() {
		Iterable<Banner> banners = bannerService.getBanners();
	}
}
