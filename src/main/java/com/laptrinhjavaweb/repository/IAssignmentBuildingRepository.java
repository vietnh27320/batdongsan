package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;

public interface IAssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity> {
    void deleteByBuildingId(long buildingId);
}
