package com.example.cinema.repository;

import com.example.cinema.model.CategoryModel;
import com.example.cinema.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAll(){
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getById(Integer id){
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel save(CategoryModel categoryModel){
        return categoryCrudRepository.save(categoryModel);
    }

    public void delete (CategoryModel categoryModel){
        categoryCrudRepository.delete(categoryModel);
    }
}
