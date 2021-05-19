package com.kafkaecosystem.domain;

import java.util.ArrayList;
import java.util.List;


public class ListFinalResult {
	
	private List<FinalResult> finalResList = new ArrayList<>();

	public List<FinalResult> getFinalResList() {
		return finalResList;
	}

	public void setFinalResList(List<FinalResult> finalResList) {
		this.finalResList = finalResList;
	}

}
