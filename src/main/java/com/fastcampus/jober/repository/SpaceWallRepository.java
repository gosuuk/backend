package com.fastcampus.jober.repository;

import com.fastcampus.jober.data.entity.SpaceWall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceWallRepository extends JpaRepository<SpaceWall, Long> {
}

