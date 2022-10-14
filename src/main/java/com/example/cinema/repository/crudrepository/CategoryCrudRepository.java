package com.example.cinema.repository.crudrepository;

import com.example.cinema.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository <CategoryModel, Integer> {
}
