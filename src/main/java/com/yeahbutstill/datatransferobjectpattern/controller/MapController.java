package com.yeahbutstill.datatransferobjectpattern.controller;

import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.LocationDTO;
import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.UserLocationDTO;
import com.yeahbutstill.datatransferobjectpattern.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation() {
        List<UserLocationDTO> usersLocation = mapService.getAllUsersLocation();
        return usersLocation;
    }


    @GetMapping("/v2")
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation_Mapper() {
        List<UserLocationDTO> usersLocation = mapService.getAllUsersLocation_V2();
        return usersLocation;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public UserLocationDTO getUserLocation(@PathVariable("id") Long id) {
        return mapService.getUserLocation(id);
    }

    @PostMapping(value = "/addLocation")
    @ResponseStatus(HttpStatus.OK)
    public void addLocation(@RequestBody LocationDTO locationDTO) {
        mapService.addLocation(locationDTO);
    }

    @GetMapping(value = "/allLocations")
    @ResponseBody
    public List<LocationDTO> getAllLocations() {
        List<LocationDTO> locations = mapService.getAllLocations();
        return locations;
    }

}
