package com.yeahbutstill.datatransferobjectpattern.controller;

import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.UserLocationDTO;
import com.yeahbutstill.datatransferobjectpattern.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("/map")
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation() {
        List<UserLocationDTO> userLocationDTOS = mapService.getAllUsersLocation();
        return userLocationDTOS;
    }

}
