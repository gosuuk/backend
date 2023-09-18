package com.fastcampus.jober.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaceWallUpdateDTO {

    private Long layoutId;
    private String url;
    private String title;
    private String description;
    private String profileImageUrl;
    private String backgroundImageUrl;
    private String pathIds;
    private String shareUrl;
    private String shareExpiredAt;

    public SpaceWallUpdateDTO() {
    }

    public SpaceWallUpdateDTO(Long layoutId, String url, String title, String description,
                              String profileImageUrl, String backgroundImageUrl, String pathIds,
                              String shareUrl, String shareExpiredAt) {
        this.layoutId = layoutId;
        this.url = url;
        this.title = title;
        this.description = description;
        this.profileImageUrl = profileImageUrl;
        this.backgroundImageUrl = backgroundImageUrl;
        this.pathIds = pathIds;
        this.shareUrl = shareUrl;
        this.shareExpiredAt = shareExpiredAt;
    }

}

