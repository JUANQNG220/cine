package com.example.cinema.service;

import com.example.cinema.model.CategoryModel;
import com.example.cinema.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<CategoryModel> getById(Integer id){
        return categoryRepository.getById(id);
    }

    public CategoryModel save(CategoryModel categoryModel){
        if(categoryModel.getId() ==null){
            return categoryRepository.save(categoryModel);

        }else {
            Optional<CategoryModel> optional=categoryRepository.getById(categoryModel.getId());
            if(optional.isEmpty()){
                return  categoryRepository.save((categoryModel));
            } else{
                return categoryModel;
            }
        }
    }

    public CategoryModel update(CategoryModel categoryModel){
        if(categoryModel.getId() != null){
            Optional<CategoryModel> optional =categoryRepository.getById(categoryModel.getId());
            if(!optional.isEmpty()) {
                if(categoryModel.getName()!= null){
                    optional.get().setName(categoryModel.getName());
                }
                if(categoryModel.getDescription()!= null){
                    optional.get().setDescription(categoryModel.getDescription());
                }
                if(categoryModel.getCinemas()!= null){
                    optional.get().setCinemas(categoryModel.getCinemas());
                }
                categoryRepository.save(optional.get());
                return optional.get();
            }else {
                return categoryModel;
            }
        }else{
            return  categoryModel;
        }
    }


    public boolean delete(Integer id){
        Boolean aBoolean = getById(id).map(box->{
            categoryRepository.delete(box);
            return true;
        }).orElse(false);
        return  aBoolean;
    }

}
