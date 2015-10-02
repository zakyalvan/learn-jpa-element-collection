package com.jakartawebs.learn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;
import com.jakartawebs.learn.entity.BannerRepository;

@Service
@Transactional(readOnly=true)
public class DefaultBannerService implements BannerService {
	@Autowired
	private BannerRepository bannerRepository;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Banner createBanner(Collection<Position> positions) {
		Banner banner = new Banner();
		banner.setPositions(new ArrayList<>(positions));
		return bannerRepository.save(banner);
	}

	@Override
	public List<Banner> getBanners() {
		return bannerRepository.findAll();
	}
}
