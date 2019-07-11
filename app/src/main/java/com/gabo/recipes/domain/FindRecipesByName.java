package com.gabo.recipes.domain;

import com.gabo.recipes.data.Recipe;

import java.util.List;

public class FindRecipesByName implements InteractorCommand<List<Recipe>, String> {

    @Override
    public List<Recipe> execute(String param) {
        return null;
    }
}
