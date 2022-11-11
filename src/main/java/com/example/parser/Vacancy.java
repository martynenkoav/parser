package com.example.parser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * This is a Vacancy class to contain information about vacancy
 */


@Entity
@Getter
@Setter
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "salary")
    private String salary;

    @Column(name = "date")
    private LocalDate date;


    public Vacancy(String name, String company, String imageLink, String salary, LocalDate date) {
        this.name = name;
        this.company = company;
        this.imageLink = imageLink;
        this.salary = salary;
        this.date = date;
    }

    public Vacancy() {

    }
}
