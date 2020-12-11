package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {

	public static void main(String[] args) {
		IBuildingService buildingService = new BuildingService();
		/*
		 * String[] type = new String[] { "TANG_TRET", "NGUYEN_CAN" }; Integer
		 * rentAreaFrom = 300; Integer rentAreaTo = 400;
		 * 
		 * // tra ve danh sach building(dto) IBuildingService buildingService = new
		 * BuildingService(); List<BuildingDTO> results = buildingService.findAll(); for
		 * (BuildingDTO item : results) { System.out.println("Tên tòa nhà: " +
		 * item.getName()); System.out.println("Phường: " + item.getWard());
		 * System.out.println("Số tầng hầm: " + item.getNumberOfBasement());
		 * System.out.println("-------------------");
		 */
		BuildingDTO buildingDTO = new BuildingDTO();
//		buildingDTO.setId(1L);
//		buildingDTO.setName("Nam Giao Building Tower 2222");
//		buildingService.update(buildingDTO);
		buildingDTO.setName("test");
		buildingDTO.setWard("test");
		buildingService.insert(buildingDTO);
	}
}
