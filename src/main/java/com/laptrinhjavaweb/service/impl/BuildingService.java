package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	IBuildingRepository buildingRepository = new BuildingRepository();
	BuildingConverter buildingConverter = new BuildingConverter();

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
			results.add(buildingDTO);
		}
		return results;
	}

	@Override
	public void update(BuildingDTO updateBuilding) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(updateBuilding.getId());
		buildingEntity.setName(updateBuilding.getName());
		buildingRepository.update(buildingEntity);
	}

	@Override
	public void insert(BuildingDTO newBuilding) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(newBuilding.getName());
		buildingEntity.setWard(newBuilding.getWard());
		buildingRepository.insert(buildingEntity);

	}

}
