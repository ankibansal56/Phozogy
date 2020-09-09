package com.app.phozogy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.phozogy.entity.Images;

public interface ImageRepository extends JpaRepository<Images, Long>{

	@Query("from com.app.phozogy.entity.Images where category = ?1")
	List<Images> findByCategory(String category);

}
