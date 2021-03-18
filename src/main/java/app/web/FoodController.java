package app.web;

import app.constants.Categories;
import app.constants.Roles;
import app.dto.FoodDTO;
import app.entities.Category;
import app.entities.Food;
import app.repositories.CategoryRepository;
import app.repositories.FoodRepository;
import app.service.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class FoodController {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;
    private final FoodService foodService;

    public FoodController(FoodRepository foodRepository,
                          CategoryRepository categoryRepository,
                          FoodService foodService) {
        this.foodRepository = foodRepository;
        this.categoryRepository = categoryRepository;
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    private String getAllFoods(Model model) {
        List<Food> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);

        return "foods";
    }

    @GetMapping("/addFood")
    private String addFood(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("food", new FoodDTO());
        return "addFood";
    }

    @PostMapping("/addFood")
    private String addFoods(@Valid FoodDTO food, BindingResult result) {
        if (result.hasErrors()) {
            return "addFood";
        }

        Food food1 = new Food();
        food1.setName(food.getName());
        food1.setDescription(food.getDescription());
        food1.setPrice(food.getPrice());
        food1.setCategories(Arrays.asList(
                categoryRepository.findByName(food.getCategory())));
        foodRepository.save(food1);
        return "redirect:/foods";
    }

    @GetMapping("/addCategory")
    private String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addCategory")
    private String addCategory(@Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "addCategory";
        }
        Category categ = new Category();
        categ.setName(category.getName());
        categoryRepository.save(categ);
        return "redirect:/foods";
    }
}
