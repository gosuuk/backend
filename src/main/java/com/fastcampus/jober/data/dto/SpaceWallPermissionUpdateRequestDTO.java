package com.fastcampus.jober.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaceWallPermissionUpdateRequestDTO {
    private Long targetId;
    private String authType;
    private String authStatus;

    public SpaceWallPermissionUpdateRequestDTO(Long targetId, String authType, String authStatus) {
        this.targetId = targetId;
        this.authType = authType;
        this.authStatus = authStatus;
    }
}
