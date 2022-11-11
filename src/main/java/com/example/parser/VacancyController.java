package com.example.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * This is a VacancyController class, it helps get vacancies from database
 */

@RestController
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping(value = "/getVacancies")
    public List<Vacancy> getListInformation() throws IOException {
        return vacancyService.findVacancyInfo();
    }
}
