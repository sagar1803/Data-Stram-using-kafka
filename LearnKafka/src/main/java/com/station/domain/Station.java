package com.station.domain;

import com.opencsv.bean.CsvBindByName;

public class Station {

	@CsvBindByName
	private Integer stop_id;
	
	@CsvBindByName
	private String direction_id;
	
	@CsvBindByName
	private String stop_name;
	
	@CsvBindByName
	private String station_name;
	
	@CsvBindByName
	private String station_descriptive_name;
	
	@CsvBindByName
	private Integer station_id;
	
	@CsvBindByName
	private Integer order;
	
	@CsvBindByName
	private boolean red;
	
	@CsvBindByName
	private boolean blue;
	
	@CsvBindByName
	private boolean green;

	public Integer getStop_id() {
		return stop_id;
	}

	public void setStop_id(Integer stop_id) {
		this.stop_id = stop_id;
	}

	public String getDirection_id() {
		return direction_id;
	}

	public void setDirection_id(String direction_id) {
		this.direction_id = direction_id;
	}

	public String getStop_name() {
		return stop_name;
	}

	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_descriptive_name() {
		return station_descriptive_name;
	}

	public void setStation_descriptive_name(String station_descriptive_name) {
		this.station_descriptive_name = station_descriptive_name;
	}

	public Integer getStation_id() {
		return station_id;
	}

	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isBlue() {
		return blue;
	}

	public void setBlue(boolean blue) {
		this.blue = blue;
	}

	public boolean isGreen() {
		return green;
	}

	public void setGreen(boolean green) {
		this.green = green;
	}
	
	
}
