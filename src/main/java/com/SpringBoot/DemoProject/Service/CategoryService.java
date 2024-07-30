package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Category;
import com.SpringBoot.DemoProject.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> CategoryGetApi() {
        return categoryRepository.findAll();
    }

    public String CategoryPostApi(Category category) {
        category.setCreatedOn(LocalDate.now());
        category.setStatus(true);
        categoryRepository.save(category);
        return " Category Record Saved ! ";
    }

    public String CategoryPutApi(Category category) {
        categoryRepository.save(category);
        return " Category Record Update ! ";
    }

    public String CategoryDeleteApi(long categoryId) {
        categoryRepository.deleteById(categoryId);
        return " Delete Record Successfully !";
    }

    public String CategoryDeleteListApi(List<Long> categoryId) {
        for(Long category :categoryId) {
            categoryRepository.deleteById(category);
        }
        return " List of ID Deleted Successfully !";
    }

}
