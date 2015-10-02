package com.jakartawebs.learn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="violet_banner")
@SuppressWarnings("serial")
public class Banner implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="violet_banner_position", joinColumns=@JoinColumn(name="banner_id", referencedColumnName="id"))
	@Enumerated(EnumType.STRING)
	@Column(name="position")
	private List<Banner.Position> positions = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public List<Banner.Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Banner.Position> positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", positions=" + positions + "]";
	}

	public static enum Position {
		HOME, BENEFIT, MERCHANT, PROMOTION
	}
}
