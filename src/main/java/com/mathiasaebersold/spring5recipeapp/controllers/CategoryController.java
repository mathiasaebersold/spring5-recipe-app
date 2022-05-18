package com.mathiasaebersold.spring5recipeapp.controllers;

import com.mathiasaebersold.spring5recipeapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping({"/category", "/category/"})
    @ResponseBody
    public String getCategory() {

        return categoryRepository.findAll().toString();
    }
}
