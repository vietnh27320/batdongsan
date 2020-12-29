package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.IRentAreaRepository;
import com.laptrinhjavaweb.repository.impl.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.repository.impl.RentAreaRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

    IBuildingRepository buildingRepository = new BuildingRepository();
    BuildingConverter buildingConverter = new BuildingConverter();
    IRentAreaRepository rentAreaRepository = new RentAreaRepository();
    IAssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepository();

//	@Override
//	public List<BuildingDTO> findAll() {
//		List<BuildingDTO> results = new ArrayList<>();
//		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
//		for (BuildingEntity item : buildingEntities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
//			results.add(buildingDTO);
//		}
//		return results;
//	}

    @Override
    public void update(BuildingDTO updateBuilding) {
//		BuildingEntity buildingEntity = new BuildingEntity();
//		buildingEntity.setId(updateBuilding.getId());
//		buildingEntity.setName(updateBuilding.getName());
//		buildingRepository.update(buildingEntity);
    }

    @Override
    public void insert(BuildingDTO newBuilding) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(newBuilding);
        //type
        Long buildingId = buildingRepository.insert(buildingEntity);
        //rentarea
        String[] rentArea = new String[]{};
        if (rentArea != null && rentArea.length > 0) {
            for (String item : rentArea) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuildingid(buildingId);
                rentAreaEntity.setValue(Integer.parseInt(item));
                rentAreaRepository.insert(rentAreaEntity);
            }
        }
    }

    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
        List<BuildingDTO> results = new ArrayList<>();
        Map<String, Object> params = convertDataToMap(builder);
        //logic lấy giá trị từ builder push vào map
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder, params);
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            results.add(buildingDTO);
        }
        return results;
    }

    @Override
    public BuildingDTO findById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id);
        BuildingDTO result = buildingConverter.convertToDto(buildingEntity);
        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilidingId(result.getId());

        return result;
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            rentAreaRepository.deleteByBuildingId(item);
            assignmentBuildingRepository.deleteByBuildingId(item);
            buildingRepository.delete(item);
        }

    }

    private Map<String, Object> convertDataToMap(BuildingSearchBuilder builder) {
        Map<String, Object> results = new HashMap<>();
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().startsWith("areaRent") && !field.getName().equals("types")
                        && !field.getName().startsWith("costRent")) {
                    field.setAccessible(true);
                    results.put(field.getName(), field.get(builder));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
        return results;
    }

}
