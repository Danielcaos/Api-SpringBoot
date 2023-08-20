package com.api.database.repository;

import com.api.database.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Integer> {
}
