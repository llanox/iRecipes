package com.gabo.recipes.presentation.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gabo.recipes.R;
import com.gabo.recipes.data.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeSearchActivity extends AppCompatActivity implements RecipeSearchView {

    private RecipeSearchPresenter recipeSearchPresenter = new RecipeSearchPresenter();
    private RecipeRecyclerViewAdapter recipeRecyclerViewAdapter;
    private TextView noResultsMessageView;
    private TextView errorMessageView;
    private  RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.results_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recipeRecyclerViewAdapter = new RecipeRecyclerViewAdapter(this, new ArrayList<Recipe>());
        recyclerView.setAdapter(recipeRecyclerViewAdapter);
        noResultsMessageView = findViewById(R.id.noResultMessage);
        errorMessageView = findViewById(R.id.errorMessage);
    }

    protected void onResume() {
        super.onResume();
        recipeSearchPresenter.attachView(this);
        recipeSearchPresenter.init();

    }

    protected void onPause() {
        super.onPause();
        recipeSearchPresenter.detachView();
    }

    @Override
    public void startSearchQueryAnimation() {

    }

    @Override
    public void stopSearchQueryAnimation() {

    }

    @Override
    public void showResults(List<Recipe> result) {
        recipeRecyclerViewAdapter.setRecipes(result);
    }

    @Override
    public void showEmptyResultScreen() {
        noResultsMessageView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showRecipeDetail(Recipe recipe) {

    }

    @Override
    public void showError() {
        errorMessageView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
