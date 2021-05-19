package com.trainarrival.domain;

public class Arrival {

	private Integer station_id;
	private Integer train_id;
	private String direction;
	private Integer line;
	private String train_status;
	private String prev_station;
	private String prev_direction;
	
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}
	public Integer getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Integer train_id) {
		this.train_id = train_id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public String getTrain_status() {
		return train_status;
	}
	public void setTrain_status(String train_status) {
		this.train_status = train_status;
	}
	public String getPrev_station() {
		return prev_station;
	}
	public void setPrev_station(String prev_station) {
		this.prev_station = prev_station;
	}
	public String getPrev_direction() {
		return prev_direction;
	}
	public void setPrev_direction(String prev_direction) {
		this.prev_direction = prev_direction;
	}
	
}
