package com.fastcampus.jober.data.dto;

import com.fastcampus.jober.data.entity.SpaceWallPermission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaceWallPermissionResponseDTO {
    private Long id;
    private Long spaceWallId;
    private Long memberId;
    private String authType;
    private String authStatus;
}
