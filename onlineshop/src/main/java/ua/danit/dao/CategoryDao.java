package ua.danit.dao;

import ua.danit.model.CategoryType;

import java.util.List;

public interface CategoryDao {

    List<CategoryType> getAllCategories();
}
