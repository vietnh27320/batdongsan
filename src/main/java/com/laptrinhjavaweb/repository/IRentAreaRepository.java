package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.RentAreaEntity;

import java.util.List;

public interface IRentAreaRepository extends JpaRepository<RentAreaEntity> {
    List<RentAreaEntity> findByBuilidingId(long id);
    void deleteByBuildingId(long buildingId);
}
