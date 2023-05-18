package ru.job4j.dish.service;

import ru.job4j.dish.model.Dish;

import java.util.*;

public interface DishService {

    Dish create(Dish dish);

    boolean update(Dish dish);

    boolean delete(int id);

    List<Dish> findAll();

    Optional<Dish> findById(int id);
}