package com.fastcampus.jober.data.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "space_wall")
public class SpaceWall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "layout_id", nullable = false)
    private SpaceWallLayout layout;

    @ManyToOne
    @JoinColumn(name = "create_member_id", nullable = false)
    private Member createMember;

    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @Column(nullable = true, length = 100)
    private String url;

    @Column(nullable = true, length = 100)
    private String title;

    @Column(nullable = true, length = 100)
    private String description;

    @Column(name = "profile_image_url", nullable = true, length = 200)
    private String profileImageUrl;

    @Column(name = "background_image_url", nullable = true, length = 200)
    private String backgroundImageUrl;

    @Column(name = "path_ids", nullable = true, length = 100)
    private String pathIds;

    @Column(name = "share_url", nullable = true, length = 100)
    private String shareUrl;

    @Column(name = "share_expired_at", nullable = true)
    private LocalDateTime shareExpiredAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @Column(nullable = false)
    private int sequence;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
