package com.example.springboot.repositories;

import com.example.springboot.model.School;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {

    @Query("Select sc From School sc")
    List<School> findAllSchools(Pageable page);
}
