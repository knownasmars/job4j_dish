package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ru.job4j.dish.model.*;
import ru.job4j.dish.repository.*;

import javax.transaction.*;
import java.util.*;

@Service
@AllArgsConstructor
public class SpringDishService implements DishService {

    private final DishRepository dishRepository;

    @Override
    @Transactional
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public boolean update(Dish dish) {
        var res = dishRepository.findById(dish.getId());
        if (res.isEmpty()) {
            return false;
        }
        dishRepository.save(dish);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        var res = dishRepository.findById(id);
        if (res.isEmpty()) {
            return false;
        }
        dishRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }
}