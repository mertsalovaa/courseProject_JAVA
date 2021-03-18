package app.service;

import app.entities.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();

    void save(Food food);

    Food getById(long id);

    void deleteById(long id);
}
