package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;

public class AssignmentBuildingRepository extends SimpleJpaRepository<AssignmentBuildingEntity> implements IAssignmentBuildingRepository {

    @Override
    public void deleteByBuildingId(long buildingId) {
        String where = "where buildingid = " + buildingId + "";
        this.deleteByProperty(where);
    }
}
