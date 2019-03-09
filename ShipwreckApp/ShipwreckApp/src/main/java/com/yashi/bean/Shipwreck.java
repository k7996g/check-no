package com.yashi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipwreck {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "NameofShip", length = 20)
	private String name;
	private String description;
	private String condition;
	private int depth;
	private double latitude;
	private double longitude;
	private int yeardis;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getYeardis() {
		return yeardis;
	}
	public void setYeardis(int yeardis) {
		this.yeardis = yeardis;
	}
	@Override
	public String toString() {
		return "Shipwreck [id=" + id + ", name=" + name + ", description=" + description + ", condition=" + condition
				+ ", depth=" + depth + ", latitude=" + latitude + ", longitude=" + longitude + ", yeardis=" + yeardis
				+ "]";
	}
	public Shipwreck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shipwreck(long id, String name, String description, String condition, int depth, double latitude,
			double longitude, int yeardis) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.condition = condition;
		this.depth = depth;
		this.latitude = latitude;
		this.longitude = longitude;
		this.yeardis = yeardis;
	}

}
