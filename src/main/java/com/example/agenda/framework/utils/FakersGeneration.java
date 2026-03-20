package com.example.agenda.framework.utils;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class FakersGeneration {
    private final Faker faker;

    public FakersGeneration() {
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getNome() {
        return faker.name().firstName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getTelefone() {
        return faker.phoneNumber().cellPhone();
    }

    public String getDataNascimento() {
        return faker.date().toString();
    }

    public Integer getNumero(Integer max) {
        return faker.number().numberBetween(0, max);
    }

    public Integer getDia() {
        return faker.number().numberBetween(1, LocalDate.now().getDayOfMonth());
    }

    public Integer getMes() {
        return faker.number().numberBetween(1, LocalDate.now().getMonthValue());
    }

    public Integer getAno() {
        return faker.number().numberBetween(1950, LocalDate.now().getYear());
    }
}
