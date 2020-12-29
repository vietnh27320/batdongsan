package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
//	List<BuildingDTO> findAll();

    void update(BuildingDTO updateBuilding);

    void insert(BuildingDTO newBuilding);

    List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder);

    BuildingDTO findById(Long id);

    void delete(long[] ids);
}
