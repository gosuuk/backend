package com.fastcampus.jober.repository;


import com.fastcampus.jober.data.entity.SpaceWallPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpaceWallPermissionRepository extends JpaRepository<SpaceWallPermission, Long> {
    Optional<SpaceWallPermission> findBySpaceWallIdAndMemberId(Long spaceWallId, Long memberId);
}
