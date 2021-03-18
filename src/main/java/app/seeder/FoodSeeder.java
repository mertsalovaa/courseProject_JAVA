package app.seeder;

import app.constants.Categories;
import app.entities.Category;
import app.entities.Food;
import app.repositories.CategoryRepository;
import app.repositories.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FoodSeeder {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    public FoodSeeder(FoodRepository foodRepository,
                      CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.categoryRepository = categoryRepository;
    }

    public void Seeder() {
        SeedCategory();
        SeedFood();
    }

    public void SeedCategory() {
        if (categoryRepository.count() == 0) {
            Category category = new Category();
            category.setName(Categories.Salad);
            categoryRepository.save(category);
            category = new Category();
            category.setName(Categories.Snack);
            categoryRepository.save(category);
        }
    }

    public void SeedFood() {
        if (foodRepository.count() == 0) {
            Food food = new Food();
            food.setName("Greek salad");
            food.setPrice(100);
            food.setDescription("Very tasty salad !");
            food.setCategories(Arrays.asList(
                    categoryRepository.findByName(Categories.Salad)));
            foodRepository.save(food);
        }
    }
}