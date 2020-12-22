package com.laptrinhjavaweb.controller.web;

import java.util.List;

import com.laptrinhjavaweb.constant.DistrictConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {

	public static void main(String[] args) {
		IBuildingService buildingService = new BuildingService();

		String[] type = new String[] { "TANG_TRET", "NGUYEN_CAN" };
		Integer rentAreaFrom = 300;
		Integer rentAreaTo = 400;

		// tra ve danh sach building(dto)

		List<BuildingDTO> results = buildingService.findAll();
		for (BuildingDTO item : results) {
			System.out.println("Tên tòa nhà: " + item.getName());
			System.out.println("Phường: " + item.getWard());
			System.out.println("Số tầng hầm: " + item.getNumberOfBasement());

			/*switch (item.getDistrict()) {
			case DistrictConstant.QUAN_1_CODE:
				System.out.println("Quận: " + DistrictConstant.QUAN_1_NAME);
				break;
			case DistrictConstant.QUAN_2_CODE:
				System.out.println("Quận: " + DistrictConstant.QUAN_2_NAME);
				break;
			case DistrictConstant.QUAN_3_CODE:
				System.out.println("Quận: " + DistrictConstant.QUAN_3_NAME);
				break;
			case DistrictConstant.QUAN_4_CODE:
				System.out.println("Quận: " + DistrictConstant.QUAN_4_NAME);
				break;

			default:
				System.out.println("chưa có quận" );
				break;
			}*/
			for (DistrictEnum district : DistrictEnum.values()) { 
				if(district.name().equals(item.getDistrict())) {
					System.out.println("Quận: " + district.getValue());
					break;
				}
			}
			System.out.println("-------------------");

//		BuildingDTO buildingDTO = new BuildingDTO();
////		buildingDTO.setId(1L);
////		buildingDTO.setName("Nam Giao Building Tower 2222");
////		buildingService.update(buildingDTO);
//		buildingDTO.setName("test");
//		buildingDTO.setWard("test");
//		buildingService.insert(buildingDTO);
		}
	}
}