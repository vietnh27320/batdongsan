package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.IRentAreaRepository;

import java.util.List;

public class RentAreaRepository extends SimpleJpaRepository<RentAreaEntity> implements IRentAreaRepository {
    @Override
    public List<RentAreaEntity> findByBuilidingId(long buildingId) {
        String where = "AND buildingid = " + buildingId + "";
        return this.findAll(where);
    }

    @Override
    public void deleteByBuildingId(long buildingId) {
        String where = "where buildingid = " + buildingId + "";
        this.deleteByProperty(where);
    }
}
