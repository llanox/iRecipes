package com.gabo.recipes.presentation.search;

import com.gabo.recipes.core.BasePresenter;
import com.gabo.recipes.data.Recipe;
import com.gabo.recipes.domain.FindAllRecipes;
import com.gabo.recipes.domain.FindRecipeById;
import com.gabo.recipes.domain.FindRecipesByName;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RecipeSearchPresenter extends BasePresenter<RecipeSearchView> {

    private FindRecipesByName findRecipesByName = new FindRecipesByName();
    private FindAllRecipes findAllRecipes =  new FindAllRecipes();
    private FindRecipeById findRecipesById = new FindRecipeById();


    public void loadRecipes(){
        if(!isValid()) return;

        view.startSearchQueryAnimation();

       findAllRecipes.execute(null).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(this::showResults, this::handleError);

    }

    private void handleError(Throwable throwable) {
        if(!isValid()) return;
        view.showError();
    }

    private void showResults(List<Recipe> recipes) {
        if(recipes.isEmpty()){
            view.showEmptyResultScreen();
        } else {
            view.showResults(recipes);
        }
        view.stopSearchQueryAnimation();
    }


    public void findRecipesByName(String query){
        if(!isValid()) return;

        view.startSearchQueryAnimation();
        List<Recipe> recipes = findRecipesByName.execute(query);

        if(recipes.isEmpty()){
            view.showEmptyResultScreen();
        } else {
            view.showResults(recipes);
        }

        view.stopSearchQueryAnimation();
    }

    public void showRecipeDetails(String id){
        if(!isValid()) return;

        Recipe result = findRecipesById.execute(id);

        if(result==null){
            view.showEmptyResultScreen();
            return;
        }

        view.showRecipeDetail(result);

    }

    public void init() {
        loadRecipes();
    }
}
