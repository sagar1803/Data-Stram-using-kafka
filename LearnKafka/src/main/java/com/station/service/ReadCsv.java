package com.station.service;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.station.domain.Station;

public class ReadCsv {
	private String csvFileName;
	private List<Station> stationList;
	
	public ReadCsv(String csvFileName){
		
		this.csvFileName = csvFileName;
	}
	
	public List<Station> ReadCSVFile(){
		try {
			CSVReader csvReader = new CSVReader(new FileReader(csvFileName));
			CsvToBean<Station> csvToBean = new CsvToBeanBuilder<Station>(csvReader)
					.withType(Station.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			stationList = csvToBean.parse();
		}catch(Exception ex) {
			System.out.println("File not found");
		}
		return stationList;
	}
}
