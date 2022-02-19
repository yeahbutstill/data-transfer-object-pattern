package com.yeahbutstill.datatransferobjectpattern.domain.dto.common;

import lombok.Data;

@Data
public class UserLocationDTO {

    private Long userId;
    private String username;
    private double lat;
    private double lng;
    private String place;

}
