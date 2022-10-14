package com.example.cinema.controller;

import com.example.cinema.model.CategoryModel;
import com.example.cinema.model.CinemaModel;
import com.example.cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{idcategory}")
    public Optional<CategoryModel> getById(@PathVariable("idcategory") Integer id){
        return categoryService.getById(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel save(@RequestBody CategoryModel categoryModel){
        return categoryService.save(categoryModel);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel update (@RequestBody CategoryModel categoryModel){
        return categoryService.update(categoryModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  boolean delete(@PathVariable("id") Integer id){
        return categoryService.delete(id);
    }
}
