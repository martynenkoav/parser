package com.example.parser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a VacancyRepository interface, which helps us to work with database
 */

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

}
