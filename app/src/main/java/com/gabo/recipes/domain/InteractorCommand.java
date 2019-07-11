package com.gabo.recipes.domain;

public interface InteractorCommand<U,T> {
     public U execute( T param );
}
