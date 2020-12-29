package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

    private IBuildingService buildingService = new BuildingService();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("model") BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/home");
        BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
                .setName(model.getName())
                .setWard(model.getWard())
                .setStreet(model.getStreet())
                .setFloorArea(model.getFloorArea())
                .setNumberOfBasement(model.getNumberOfBasement())
                .setStaffId(model.getStaffId())
                .build();
        mav.addObject("buildings", buildingService.findAll(builder));
        mav.addObject("model",model);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute("model") BuildingDTO model,
                                     @RequestParam(value = "id", required = false) Long buildingId){
        ModelAndView mav = new ModelAndView("admin/edit");
        if(buildingId != null){
            model = buildingService.findById(buildingId);
        }else{

        }
        mav.addObject("model",model);
        return mav;
    }
}
