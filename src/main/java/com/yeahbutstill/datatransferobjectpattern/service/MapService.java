package com.yeahbutstill.datatransferobjectpattern.service;

import com.yeahbutstill.datatransferobjectpattern.domain.dao.LocationDao;
import com.yeahbutstill.datatransferobjectpattern.domain.dao.UserDao;
import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.UserLocationDTO;
import com.yeahbutstill.datatransferobjectpattern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapService {

    private final UserRepository userRepository;

    public List<UserLocationDTO> getAllUsersLocation() {
        return ((List<UserDao>) userRepository
                .findAll())
                .stream()
                .map(this::convertToUserLocationDTO)
                .collect(Collectors.toList());
    }

    private UserLocationDTO convertToUserLocationDTO(UserDao userDao) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(userDao.getId());
        userLocationDTO.setUsername(userDao.getUsername());
        LocationDao locationDao = userDao.getLocationDao();
        userLocationDTO.setLat(locationDao.getLat());
        userLocationDTO.setLng(locationDao.getLng());
        userLocationDTO.setPlace(locationDao.getPlace());
        return userLocationDTO;
    }

}
