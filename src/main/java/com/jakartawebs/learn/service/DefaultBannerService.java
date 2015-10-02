package com.jakartawebs.learn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jakartawebs.learn.entity.Banner;
import com.jakartawebs.learn.entity.Banner.Position;
import com.jakartawebs.learn.entity.BannerRepository;
import com.mysema.query.types.Predicate;

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
	public Banner getBanner(Long id) {
		return bannerRepository.findOne(id);
	}

	@Override
	public Banner getBanner(Predicate predicate) {
		return bannerRepository.findOne(predicate);
	}

	@Override
	public List<Banner> getBanners() {
		return bannerRepository.findAll();
	}

	@Override
	public Iterable<Banner> getBanners(Predicate predicate) {
		return bannerRepository.findAll(predicate);
	}

	@Override
	public Page<Banner> getBanners(Pageable pageable, Predicate predicate) {
		return bannerRepository.findAll(predicate, pageable);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeBanner(Long id) {
		bannerRepository.delete(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeBanners(Predicate predicate) {
		Iterable<Banner> banners = bannerRepository.findAll(predicate);
		bannerRepository.delete(banners);
	}
}