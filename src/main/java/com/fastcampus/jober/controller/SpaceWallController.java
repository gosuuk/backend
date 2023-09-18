package com.fastcampus.jober.controller;

import com.fastcampus.jober.data.dto.*;
import com.fastcampus.jober.data.entity.SpaceWall;
import com.fastcampus.jober.service.SpaceWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/spaces")
public class SpaceWallController {

    private final SpaceWallService spaceWallService;

    @Autowired
    public SpaceWallController(SpaceWallService spaceWallService) {
        this.spaceWallService = spaceWallService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SpaceWall>> createSpaceWall(@RequestBody SpaceWallCreateRequest request) {
        SpaceWall spaceWall = spaceWallService.createSpaceWall(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(1000, "공유페이지를 성공적으로 생성하였습니다.", spaceWall));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SpaceWallResponseDTO>> getSpaceWall(@PathVariable Long id) {
        SpaceWallResponseDTO responseDTO = spaceWallService.getSpaceWall(id);
        return ResponseEntity.ok(new ApiResponse<>(1000, "공유페이지를 성공적으로 조회하였습니다.", responseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SpaceWallResponseDTO>> updateSpaceWall(@PathVariable Long id, @RequestBody SpaceWallUpdateDTO dto) {
        SpaceWallResponseDTO responseDTO = spaceWallService.updateSpaceWall(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(1000, "공유페이지를 성공적으로 수정하였습니다.", responseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Long>>> deleteSpaceWall(@PathVariable Long id) {
        Long deletedId = spaceWallService.deleteSpaceWall(id);
        return ResponseEntity.ok(new ApiResponse<>(1000, "공유페이지를 성공적으로 삭제했습니다.", Collections.singletonMap("id", deletedId)));
    }

//    @PutMapping("/{id}/authority")
//    public ResponseEntity<ApiResponse<String>> setSpaceWallAuthority(@PathVariable Long id,
//                                                                     @RequestBody SpaceWallPermissionUpdateRequestDTO permissionDTO) {
//        spaceWallService.updateSpaceWallPermission(id, permissionDTO.getTargetMemberId(), permissionDTO.getAuthType(), permissionDTO.getAuthStatus());
//        ApiResponse<String> response = new ApiResponse<>(1000, "권한을 성공적으로 상속하였습니다.");
//        return ResponseEntity.ok(response);
//    }

}
