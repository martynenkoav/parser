package com.example.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


/**
 * This is a VacancyService class which connects controller and repository
 */


@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancySaver vacancySaver;

    public List<Vacancy> findVacancyInfo() throws IOException {
        return vacancyRepository.saveAll(vacancySaver.getVacancies());
    }
}