package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
//	List<BuildingEntity> findAll();
	void update(BuildingEntity buidingEntity);

//	void save(BuildingEntity newBuilding);

	void delete(long id);
}
