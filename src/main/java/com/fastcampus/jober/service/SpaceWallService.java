package com.fastcampus.jober.service;

import com.fastcampus.jober.config.SpaceWallNotFoundException;
import com.fastcampus.jober.data.dto.ComponentInfoDTO;
import com.fastcampus.jober.data.dto.SpaceWallCreateRequest;
import com.fastcampus.jober.data.dto.SpaceWallResponseDTO;
import com.fastcampus.jober.data.dto.SpaceWallUpdateDTO;
import com.fastcampus.jober.data.entity.Member;
import com.fastcampus.jober.data.entity.SpaceWall;
import com.fastcampus.jober.data.entity.SpaceWallPermission;
import com.fastcampus.jober.repository.SpaceWallPermissionRepository;
import com.fastcampus.jober.repository.SpaceWallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpaceWallService {

    private final SpaceWallRepository spaceWallRepository;
    private final SpaceWallPermissionRepository spaceWallPermissionRepository;

    @Autowired
    public SpaceWallService(SpaceWallRepository spaceWallRepository, SpaceWallPermissionRepository spaceWallPermissionRepository) {
        this.spaceWallRepository = spaceWallRepository;
        this.spaceWallPermissionRepository = spaceWallPermissionRepository;
    }

    @Transactional
    public SpaceWall createSpaceWall(SpaceWallCreateRequest request) {
        SpaceWall spaceWall = new SpaceWall();
        return spaceWallRepository.save(spaceWall);
    }

    @Transactional(readOnly = true)
    public SpaceWallResponseDTO getSpaceWall(Long id) {
        Optional<SpaceWall> spaceWall = spaceWallRepository.findById(id);
        if (spaceWall.isPresent()) {
            return new SpaceWallResponseDTO();
        }
        throw new SpaceWallNotFoundException(id);
    }

    @Transactional
    public SpaceWallResponseDTO updateSpaceWall(Long id, SpaceWallUpdateDTO dto) {
        Optional<SpaceWall> spaceWallOptional = spaceWallRepository.findById(id);
        if (spaceWallOptional.isPresent()) {
            SpaceWall spaceWall = spaceWallOptional.get();
            spaceWallRepository.save(spaceWall);
            return new SpaceWallResponseDTO();
        }
        throw new SpaceWallNotFoundException(id);
    }

    @Transactional
    public Long deleteSpaceWall(Long id) {
        if (spaceWallRepository.existsById(id)) {
            spaceWallRepository.deleteById(id);
            return id;
        }
        throw new SpaceWallNotFoundException(id);
    }

//    private SpaceWallResponseDTO convertToResponseDTO(SpaceWall spaceWall) {
//    SpaceWallResponseDTO dto = new SpaceWallResponseDTO();
//    // ... other property conversions ...
//
//    List<ComponentInfoDTO> componentInfoDTOS = spaceWall.getComponents() // Assuming this method exists on SpaceWall entity
//        .stream()
//        .map(component -> {
//            ComponentInfoDTO componentInfoDTO = new ComponentInfoDTO();
//            componentInfoDTO.setComponentId(component.getId());  // Assuming the component entity has getId() method
//            componentInfoDTO.setHidden(component.isHidden());  // Assuming the component entity has isHidden() method
//            return componentInfoDTO;
//        })
//        .collect(Collectors.toList());
//
//    dto.setComponents(componentInfoDTOS);
//
//    return dto;
//}

//    @Transactional
//    public void updateSpaceWallPermission(Long spaceWallId, Long targetMemberId, String authType, String authStatus) {
//        Optional<SpaceWallPermission> optionalPermission = spaceWallPermissionRepository.findBySpaceWallIdAndMemberId(spaceWallId, targetMemberId);
//
//        SpaceWallPermission permission;
//
//        if (optionalPermission.isPresent()) {
//            permission = optionalPermission.get();
//        } else {
//            permission = new SpaceWallPermission();
//            // Assuming that the SpaceWall and Member with the given IDs are present in the database.
//            // If there's a possibility they might not be, you should retrieve them safely using findById and handle the optional appropriately.
//            permission.setSpaceWall(spaceWallRepository.findById(spaceWallId).orElseThrow());
//            permission.setMember(new Member(targetMemberId));
//        }
//
//        permission.setType(authType);
//        permission.setAuths(authStatus);
//
//        spaceWallPermissionRepository.save(permission);
//    }
}
