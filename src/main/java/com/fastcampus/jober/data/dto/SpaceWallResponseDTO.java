package com.fastcampus.jober.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpaceWallResponseDTO {

    private List<ComponentInfoDTO> components;

    private Long id;
    private Long layoutId;
    private Long createMemberId;
    private Long workspaceId;
    private String url;
    private String title;
    private String description;
    private String profileImageUrl;
    private String backgroundImageUrl;
    private String pathIds;
    private String shareUrl;
    private String shareExpiredAt;
    private String createdAt;
    private String updatedAt;
    private int sequence;

    public SpaceWallResponseDTO() {
    }

    public SpaceWallResponseDTO(Long id, Long layoutId, Long createMemberId, Long workspaceId, String url,
                                String title, String description, String profileImageUrl, String backgroundImageUrl,
                                String pathIds, String shareUrl, String shareExpiredAt, String createdAt,
                                String updatedAt, int sequence) {
        this.id = id;
        this.layoutId = layoutId;
        this.createMemberId = createMemberId;
        this.workspaceId = workspaceId;
        this.url = url;
        this.title = title;
        this.description = description;
        this.profileImageUrl = profileImageUrl;
        this.backgroundImageUrl = backgroundImageUrl;
        this.pathIds = pathIds;
        this.shareUrl = shareUrl;
        this.shareExpiredAt = shareExpiredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sequence = sequence;
    }
}
