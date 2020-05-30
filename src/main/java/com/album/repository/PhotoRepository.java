package com.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.album.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
