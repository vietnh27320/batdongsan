package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
//	List<BuildingEntity> findAll();
//	void update(BuildingEntity buidingEntity);

//	void save(BuildingEntity newBuilding);

    //	void delete(long id);
//	String name, String ward, Integer numberOfBasement, Integer floorArea
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, Map<String, Object> params);

    void deleteBuilding(long[] ids);
}
