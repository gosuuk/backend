package com.fastcampus.jober.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SpaceWallCreateRequest {

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
    private LocalDateTime shareExpiredAt;
    private int sequence;

    public SpaceWallCreateRequest() {
    }

    public SpaceWallCreateRequest(Long layoutId, Long createMemberId, Long workspaceId,
                                  String url, String title, String description,
                                  String profileImageUrl, String backgroundImageUrl,
                                  String pathIds, String shareUrl,
                                  LocalDateTime shareExpiredAt, int sequence) {
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
        this.sequence = sequence;
    }

}