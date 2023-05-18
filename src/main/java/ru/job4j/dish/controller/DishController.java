package ru.job4j.dish.controller;

import lombok.*;
import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.model.*;
import ru.job4j.dish.service.*;
import ru.job4j.dish.handler.Operation;

import javax.validation.*;

import java.util.*;

@RestController
@RequestMapping("/dish")
@AllArgsConstructor
public class DishController {

    private final SpringDishService dishService;

    @GetMapping("/")
    public Collection<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var site = this.dishService.findById(id);
        return new ResponseEntity<Dish>(
                site.orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Dish is not found. Please, check requisites."
                )),
                site.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    @Validated(Operation.OnCreate.class)
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish) {
        return new ResponseEntity<Dish>(
                dishService.create(dish),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@Valid @RequestBody Dish dish) {
        if (dishService.update(dish)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (dishService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}