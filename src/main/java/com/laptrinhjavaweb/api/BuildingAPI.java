package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    IBuildingService buildingService = new BuildingService();

    @PostMapping
    public void createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.insert(buildingDTO);
    }

    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody BuildingDTO buildingDTO) {

        return null;
    }

    @DeleteMapping
    public void deleteBuilding(@RequestBody long[] ids) {
        buildingService.delete(ids);
    }
}
