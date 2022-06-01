package com.mathiasaebersold.spring5recipeapp.controllers;

import com.mathiasaebersold.spring5recipeapp.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping({"/category", "/category/"})
    @ResponseBody
    public String getCategory() {
        log.debug("Getting category");
        return categoryRepository.findAll().toString();
    }
}
