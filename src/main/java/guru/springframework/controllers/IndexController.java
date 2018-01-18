package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping({"/", "/recipes"})
    public String showRecipes(Model model) {
        log.debug("In /recipes route, going to show all existing recipes");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }
}
