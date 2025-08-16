package com.example.travelbackend.repository;



import com.example.travelbackend.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> { }

