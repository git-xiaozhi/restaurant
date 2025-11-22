package com.restaurant.controller;

import com.restaurant.model.Dish;
import com.restaurant.repository.DishRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@CrossOrigin(origins = "*")
public class DishController {
    private final DishRepository repo;

    public DishController(DishRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Dish> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Dish get(@PathVariable int id) {
        return repo.findById(id);
    }

    @PostMapping
    public String create(@RequestBody Dish d) {
        repo.save(d);
        return "ok";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Dish d) {
        d.setId(id);
        repo.update(d);
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repo.delete(id);
        return "ok";
    }
}