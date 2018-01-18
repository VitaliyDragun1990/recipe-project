package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void  initData() {
        // Retrieve category
        Category mexican = categoryRepository.findByDescription("Mexican").get();

        // Retrieve all needed units of measure
        UnitOfMeasure piece = unitRepository.findByDescription("Piece").get();
        UnitOfMeasure teaspoon = unitRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dash = unitRepository.findByDescription("Dash").get();
        UnitOfMeasure cup = unitRepository.findByDescription("Cup").get();
        UnitOfMeasure pint = unitRepository.findByDescription("Pint").get();

        /*************** GUACAMOLE **********************/

        // Create recipe - Guacamole
        Recipe guacamole = new Recipe();

        // Ingredients
        Ingredient avocado = new Ingredient();
        avocado.setUom(piece);
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setDescription("Avocado");
        avocado.setRecipe(guacamole);

        Ingredient kosherSalt = new Ingredient();
        kosherSalt.setUom(teaspoon);
        kosherSalt.setAmount(BigDecimal.valueOf(1.5));
        kosherSalt.setDescription("Kosher salt");
        kosherSalt.setRecipe(guacamole);

        Ingredient limeJuice = new Ingredient();
        limeJuice.setUom(tablespoon);
        limeJuice.setAmount(BigDecimal.valueOf(1));
        limeJuice.setDescription("Lime Juice");
        limeJuice.setRecipe(guacamole);

        Ingredient redUnion = new Ingredient();
        redUnion.setUom(tablespoon);
        redUnion.setAmount(BigDecimal.valueOf(2));
        redUnion.setDescription("Red union");
        redUnion.setRecipe(guacamole);

        Ingredient serranoChiles = new Ingredient();
        serranoChiles.setUom(piece);
        serranoChiles.setAmount(BigDecimal.valueOf(2));
        serranoChiles.setDescription("Serrano chile");
        serranoChiles.setRecipe(guacamole);

        Ingredient cilantro = new Ingredient();
        cilantro.setUom(tablespoon);
        cilantro.setAmount(BigDecimal.valueOf(2));
        cilantro.setDescription("Cilantro");
        cilantro.setRecipe(guacamole);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setUom(dash);
        blackPepper.setAmount(BigDecimal.valueOf(1));
        blackPepper.setDescription("Black pepper");
        blackPepper.setRecipe(guacamole);

        Ingredient tomato = new Ingredient();
        tomato.setUom(piece);
        tomato.setAmount(BigDecimal.valueOf(2));
        tomato.setDescription("Tomato");
        tomato.setRecipe(guacamole);
        // Note
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Guacamole, a dip made from avocados, is originally from Mexico");

        // Recipe
        guacamole.setDescription("The BEST guacamole!");
        guacamole.getCategories().add(mexican);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("All you really need to make guacamole is ripe avocados and salt");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(4);
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setNotes(guacamoleNotes);
        guacamole.addIngredient(avocado).addIngredient(kosherSalt).addIngredient(limeJuice)
                .addIngredient(redUnion).addIngredient(serranoChiles).addIngredient(cilantro)
                .addIngredient(blackPepper).addIngredient(tomato);

        // save Guacamole recipe
        recipeRepository.save(guacamole);

        /*************** CHICKEN TACOS **********************/

        // Create recipe - chicken tacos
        Recipe chickenTacos = new Recipe();

        // Ingredients
        Ingredient anchoChiliPowder = new Ingredient();
        anchoChiliPowder.setUom(tablespoon);
        anchoChiliPowder.setAmount(BigDecimal.valueOf(2));
        anchoChiliPowder.setDescription("Ancho Chili Powder");
        anchoChiliPowder.setRecipe(chickenTacos);

        Ingredient driedOregano = new Ingredient();
        driedOregano.setUom(teaspoon);
        driedOregano.setAmount(BigDecimal.valueOf(1));
        driedOregano.setDescription("Dried Oregano");
        driedOregano.setRecipe(chickenTacos);

        Ingredient driedCumin = new Ingredient();
        driedCumin.setUom(teaspoon);
        driedCumin.setAmount(BigDecimal.valueOf(1));
        driedCumin.setDescription("Dried Cumin");
        driedCumin.setRecipe(chickenTacos);

        Ingredient sugar = new Ingredient();
        sugar.setUom(teaspoon);
        sugar.setAmount(BigDecimal.valueOf(1));
        sugar.setDescription("Sugar");
        sugar.setRecipe(chickenTacos);

        Ingredient salt = new Ingredient();
        salt.setUom(teaspoon);
        salt.setAmount(BigDecimal.valueOf(1.5));
        salt.setDescription("Salt");
        salt.setRecipe(chickenTacos);

        Ingredient cloveGarlic = new Ingredient();
        cloveGarlic.setUom(piece);
        cloveGarlic.setAmount(BigDecimal.valueOf(1));
        cloveGarlic.setDescription("Clove Garlic");
        cloveGarlic.setRecipe(chickenTacos);

        Ingredient orangeZest = new Ingredient();
        orangeZest.setUom(tablespoon);
        orangeZest.setAmount(BigDecimal.valueOf(1));
        orangeZest.setDescription("Orange Zest");
        orangeZest.setRecipe(chickenTacos);

        Ingredient orangeJuice = new Ingredient();
        orangeJuice.setUom(tablespoon);
        orangeJuice.setAmount(BigDecimal.valueOf(3));
        orangeJuice.setDescription("Orange Juice");
        orangeJuice.setRecipe(chickenTacos);

        Ingredient oliveOil = new Ingredient();
        oliveOil.setUom(tablespoon);
        oliveOil.setAmount(BigDecimal.valueOf(2));
        oliveOil.setDescription("Olive Oil");
        oliveOil.setRecipe(chickenTacos);

        Ingredient chickenThigh = new Ingredient();
        chickenThigh.setUom(piece);
        chickenThigh.setAmount(BigDecimal.valueOf(5));
        chickenThigh.setDescription("Chicken Thigh");
        chickenThigh.setRecipe(chickenTacos);

        // Note
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("Spicy grilled chicken tacos!");

        // Recipe
        chickenTacos.setDescription("Spicy grilled chicken tacos!");
        chickenTacos.getCategories().add(mexican);
        chickenTacos.setDifficulty(Difficulty.EASY);
        chickenTacos.setDirections("Quick marinade, then grill. Ready in about 30 minutes. ");
        chickenTacos.setPrepTime(20);
        chickenTacos.setCookTime(15);
        chickenTacos.setServings(6);
        chickenTacos.setSource("Simply Recipes");
        chickenTacos.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenTacos.setNotes(tacoNotes);
        chickenTacos.addIngredient(anchoChiliPowder).addIngredient(driedOregano)
                .addIngredient(driedCumin).addIngredient(sugar).addIngredient(salt)
                .addIngredient(cloveGarlic).addIngredient(orangeJuice).addIngredient(orangeZest)
                .addIngredient(oliveOil).addIngredient(chickenThigh);

        // save Tacos recipe
        recipeRepository.save(chickenTacos);
    }
}
