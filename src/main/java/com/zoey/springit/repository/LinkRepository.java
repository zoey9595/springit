package com.zoey.springit.repository;

import com.zoey.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

}