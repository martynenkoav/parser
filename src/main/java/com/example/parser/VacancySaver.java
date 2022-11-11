package com.example.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a VacancySaver class, which get vacancies from habrcareer
 */


@Component
public class VacancySaver {

    public List<Vacancy> getVacancies() throws IOException {
        List<Vacancy> vacancyList = new ArrayList<>();
        int i = 1;
        // one page of the site contains only 25 vacancies, so we check more pages to get enough data
        while (i <= 10) {
            String URL = String.format("https://career.habr.com/vacancies?page=%d&type=all", i);
            Document doc = Jsoup.connect(URL).get();
            Elements vacancyHTML = doc.getElementsByAttributeValue("class", "vacancy-card__inner");
            vacancyHTML.forEach(vacancy -> {
                String name = vacancy.getElementsByAttributeValue("class", "vacancy-card__title-link").text();
                String company = vacancy.getElementsByAttributeValue("class", "vacancy-card__company-title").text();
                String imageLink = vacancy.getElementsByAttributeValue("class", "vacancy-card__icon").attr("src");
                String dateStr = vacancy.getElementsByAttributeValue("class", "basic-date").attr("datetime").substring(0, 10);
                LocalDate date = LocalDate.parse(dateStr);
                String salary;
                if (!vacancy.getElementsByAttributeValue("class", "basic-salary").isEmpty()) {
                    salary = null;
                } else {
                    salary = vacancy.getElementsByAttributeValue("class", "basic-salary").text();
                }
                vacancyList.add(new Vacancy(name, company, imageLink, salary, date));
            });
            i++;
        }
        return vacancyList;
    }
}

