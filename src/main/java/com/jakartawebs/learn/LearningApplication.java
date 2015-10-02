package com.jakartawebs.learn;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;
import com.jakartawebs.learn.entity.BannerRepository;
import com.jakartawebs.learn.service.BannerService;

@SpringBootApplication
public class LearningApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(LearningApplication.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplication(LearningApplication.class).run(args);
		BannerService bannerService = applicationContext.getBean(BannerService.class);
		BannerRepository bannerRepository = applicationContext.getBean(BannerRepository.class);
		
		LOGGER.debug("Creating new banner");
		List<Position> positions = Arrays.asList(Position.BENEFIT, Position.HOME);
		Banner banner = bannerService.createBanner(positions);
		LOGGER.debug("Created new banner with id {}", banner.getId());
		Assert.isTrue(positions.size() == banner.getPositions().size());
		
		LOGGER.debug("Retrieving banners from database");
		List<Banner> banners = bannerService.getBanners();
		LOGGER.debug("Retrieved banners size : {}, with content : {}", banners.size(), banners.toString());
		Assert.isTrue(banners.size() == bannerRepository.count());
	}
}
