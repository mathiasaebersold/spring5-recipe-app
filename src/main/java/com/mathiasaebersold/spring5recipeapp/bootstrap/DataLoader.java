package com.mathiasaebersold.spring5recipeapp.bootstrap;

import com.mathiasaebersold.spring5recipeapp.model.*;
import com.mathiasaebersold.spring5recipeapp.repositories.CategoryRepository;
import com.mathiasaebersold.spring5recipeapp.repositories.RecipeRepository;
import com.mathiasaebersold.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(CategoryRepository categoryRepository, RecipeRepository repository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = repository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) {
        if (recipeRepository.findAll().spliterator().getExactSizeIfKnown() == 0) {
            loadData();
        }

    }

    private void loadData() {
        System.out.println("Loading data");

        // Categories
        Category mexican = categoryRepository.findByDescription("Mexican").orElseThrow(() -> new RuntimeException("Category Mexican is missing"));
        Category american = categoryRepository.findByDescription("American").orElseThrow(() -> new RuntimeException("Category American is missing"));
        Category fastFood = categoryRepository.findByDescription("Fast Food").orElseThrow(() -> new RuntimeException("Category Fast Food is missing"));

        // Units of measure
        UnitOfMeasure pieces = unitOfMeasureRepository.findByUom("Pieces").orElseThrow(() -> new RuntimeException("Unit of measure Pieces is missing"));
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByUom("Teaspoon").orElseThrow(() -> new RuntimeException("Unit of measure Teaspoon is missing"));
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByUom("Tablespoon").orElseThrow(() -> new RuntimeException("Unit of measure Tablespoon is missing"));
        UnitOfMeasure pinch = unitOfMeasureRepository.findByUom("Pinch").orElseThrow(() -> new RuntimeException("Unit of measure Pinch is missing"));
        UnitOfMeasure cup = unitOfMeasureRepository.findByUom("Cup").orElseThrow(() -> new RuntimeException("Unit of measure Cup is missing"));
        UnitOfMeasure pint = unitOfMeasureRepository.findByUom("Pint").orElseThrow(() -> new RuntimeException("Unit of measure Pint is missing"));

        // Guacamole
        Recipe guacamole = new Recipe();
        guacamole.setCategories(Set.of(mexican, fastFood));
        guacamole.setDescription("Perfect Guacamole");
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("The best guacamole keeps it simple: just ripe avocados and a handful of flavorful mix-ins. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
        guacamoleNotes.setRecipe(guacamole);
        guacamole.setNotes(guacamoleNotes);
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setServings(3);
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" + "\n" +
                "How to make guacamole - scoring avocado\n" +
                "Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" + "How to make guacamole - smashing avocado with fork\n" +
                "Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" + "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" + "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" + "Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" + "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" + "Refrigerate leftover guacamole up to 3 days.\n" +
                "\n" + "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.getIngredients().add(new Ingredient(guacamole, "Avocados", 2, pieces));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Kosher salt", 0.25, teaspoon));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Fresh Lime Juice", 1, tablespoon));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Minced Onion", 2, tablespoon));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Serrano", 2, pieces));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Cilantro", 2, tablespoon));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Freshly Ground Black Pepper", 2, pinch));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Ripe Tomato", 0.5, pieces));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Red Radish", 1, pieces));
        guacamole.getIngredients().add(new Ingredient(guacamole, "Tortilla Chip", 1, pieces));
        recipeRepository.save(guacamole);


        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MEDIUM);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Ancho Chili Powder", 2, tablespoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Dried Oregano", 1, teaspoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Dried Cumin", 1, teaspoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Sugar", 1, teaspoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Salt", 0.5, teaspoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Clove of Garlic, Choppedr", 1, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "finely grated orange zestr", 1, tablespoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "fresh-squeezed orange juice", 3, tablespoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Olive Oil", 2, tablespoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "boneless chicken thighs", 4, tablespoon));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "small corn tortillasr", 8, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "packed baby arugula", 3, cup));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "medium ripe avocados, slic", 2, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "radishes, thinly sliced", 4, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "cherry tomatoes, halved", 0.5, pint));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "red onion, thinly sliced", 0.25, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "Roughly chopped cilantro", 4, pieces));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "cup sour cream thinned with 1/4 cup milk", 4, cup));
        tacosRecipe.getIngredients().add(new Ingredient(tacosRecipe, "lime, cut into wedges", 4, pieces));

        tacosRecipe.setCategories(Set.of(american, mexican));

        recipeRepository.save(tacosRecipe);

    }
}
