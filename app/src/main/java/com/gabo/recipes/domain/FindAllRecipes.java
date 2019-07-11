package com.gabo.recipes.domain;

import com.gabo.recipes.data.Recipe;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class FindAllRecipes implements InteractorCommand<Observable<List<Recipe>>, Void> {

    private Retrofit retrofit = RecipeService.getClient();

    @Override
    public Observable<List<Recipe>> execute(Void param) {
        return retrofit.create(RecipesAPI.class).getRecipes();
    }
}
