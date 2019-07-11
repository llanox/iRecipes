package com.gabo.recipes.domain;
import com.gabo.recipes.data.Recipe;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RecipesAPI {
    @GET("recipes/")
    Observable<List<Recipe>> getRecipes();
}
