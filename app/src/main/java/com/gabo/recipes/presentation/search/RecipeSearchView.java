package com.gabo.recipes.presentation.search;

import com.gabo.recipes.core.BaseView;
import com.gabo.recipes.data.Recipe;

import java.util.List;

public interface RecipeSearchView extends BaseView {
    void startSearchQueryAnimation();

    void stopSearchQueryAnimation();

    void showResults(List<Recipe> result);

    void showEmptyResultScreen();

    void showRecipeDetail(Recipe recipe);

    void showError();
}

