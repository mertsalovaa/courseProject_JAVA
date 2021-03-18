package app.service;

import app.entities.Food;
import app.entities.User;
import app.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public void save(Food food) {
        this.foodRepository.save(food);
    }

    @Override
    public Food getById(long id) {
        Optional<Food> optional = foodRepository.findById(id);
        Food food = null;
        if (optional.isPresent()) {
            food = optional.get();
        } else {
            throw new RuntimeException(" Food not found for id :: " + id);
        }
        return food;
    }

    @Override
    public void deleteById(long id) {
        this.foodRepository.deleteById(id);
    }
}
