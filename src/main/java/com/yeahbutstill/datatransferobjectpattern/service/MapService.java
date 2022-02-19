package com.yeahbutstill.datatransferobjectpattern.service;

import com.yeahbutstill.datatransferobjectpattern.domain.dao.LocationDAO;
import com.yeahbutstill.datatransferobjectpattern.domain.dao.UserDAO;
import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.LocationDTO;
import com.yeahbutstill.datatransferobjectpattern.domain.dto.common.UserLocationDTO;
import com.yeahbutstill.datatransferobjectpattern.repository.LocationRepository;
import com.yeahbutstill.datatransferobjectpattern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapService {

    private final LocationRepository locationRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserLocationDTO getUserLocation(Long id) {
        return convertToUserLocationDTO(userRepository.findById(id).get());
    }


    public List<UserLocationDTO> getAllUsersLocation() {
        return ((List<UserDAO>) userRepository.findAll()).stream().map(this::convertToUserLocationDTO)
                .collect(Collectors.toList());
    }

    public List<UserLocationDTO> getAllUsersLocation_V2() {
        return ((List<UserDAO>) userRepository.findAll()).stream().map(this::convertToUserLocationDTO_V2)
                .collect(Collectors.toList());
    }

    private UserLocationDTO convertToUserLocationDTO(UserDAO userDao) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(userDao.getId());
        userLocationDTO.setUsername(userDao.getUsername());
        LocationDAO locationDAO = userDao.getLocationDao();
        userLocationDTO.setLat(locationDAO.getLat());
        userLocationDTO.setLng(locationDAO.getLng());
        userLocationDTO.setPlace(locationDAO.getPlace());
        return userLocationDTO;
    }

    private UserLocationDTO convertToUserLocationDTO_V2(UserDAO userDAO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = modelMapper.map(userDAO, UserLocationDTO.class);
        return userLocationDTO;
    }


    public void addLocation(LocationDTO locationDTO) {
        LocationDAO locationDAO = new ModelMapper().map(locationDTO, LocationDAO.class);
        locationRepository.save(locationDAO);
    }

    public List<LocationDTO> getAllLocations() {
        return ((List<LocationDAO>) locationRepository.findAll())
                .stream()
                .map(obj -> modelMapper.map(obj, LocationDTO.class))
                .collect(Collectors.toList());
    }

}
