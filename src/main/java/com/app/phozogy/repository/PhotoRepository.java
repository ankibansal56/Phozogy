package com.app.phozogy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.phozogy.entity.Photos;

@Repository
public interface PhotoRepository extends JpaRepository<Photos, Long>{
	
	@Query("select * from photos where category = :category")
	public List<String> findByCategory(@Param("category") String category); 
}
