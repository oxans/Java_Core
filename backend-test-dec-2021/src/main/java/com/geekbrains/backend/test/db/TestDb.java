package com.geekbrains.backend.test.db;

import java.util.List;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.CategoriesExample;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

public class TestDb {

    public static void main(String[] args) {

        DbService dbService = new DbService();
        ProductsMapper productsMapper = dbService.getProductsMapper();
        CategoriesMapper categoriesMapper = dbService.getCategoriesMapper();
        Products product = productsMapper.selectByPrimaryKey(1L);
        Categories category = categoriesMapper.selectByPrimaryKey(1L);
        System.out.println(product);
        System.out.println(category);


        Products forCreate = new Products();
        forCreate.setTitle("Coca cola");
        forCreate.setPrice(50);
        forCreate.setCategoryId(1L);
        productsMapper.insert(forCreate);



        ProductsExample filter = new ProductsExample();

        List<Products> products = productsMapper.selectByExample(filter);
        System.out.println(products);

        filter.createCriteria()
                .andCategoryIdEqualTo(2L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andPriceBetween(51, 1000);

        System.out.println(productsMapper.selectByExample(filter));

        product.setPrice(105);
        productsMapper.updateByPrimaryKey(product);

        System.out.println(productsMapper.selectByPrimaryKey(1L));

        filter.clear();

        Categories forCatCreate = new Categories();
        forCatCreate.setTitle("anamals");
        categoriesMapper.insert(forCatCreate);

        Products forCreateCat1 = new Products();
        forCreateCat1.setTitle("cat");
        forCreateCat1.setPrice(150);
        forCreateCat1.setCategoryId(20L);
        productsMapper.insert(forCreateCat1);

        Products forCreateCat2 = new Products();
        forCreateCat2.setTitle("dog");
        forCreateCat2.setPrice(150);
        forCreateCat2.setCategoryId(20L);
        productsMapper.insert(forCreateCat2);

        Products forCreateCat3 = new Products();
        forCreateCat3.setTitle("cat");
        forCreateCat3.setPrice(150);
        forCreateCat3.setCategoryId(20L);
        productsMapper.insert(forCreateCat3);


        System.out.println("Caterorias 20");
        filter.createCriteria()
                .andCategoryIdEqualTo(20L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();

        System.out.println("Caterorias 21");
        filter.createCriteria()
                .andCategoryIdEqualTo(21L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();

        System.out.println("Caterorias 22");
        filter.createCriteria()
                .andCategoryIdEqualTo(22L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();

        System.out.println("Caterorias 23");
        filter.createCriteria()
                .andCategoryIdEqualTo(23L);

        System.out.println(productsMapper.selectByExample(filter));

        System.out.println("More then");


        filter.clear();

        filter.createCriteria()
                .andPriceGreaterThan(20000);

        filter.getOredCriteria();
        System.out.println(productsMapper.selectByExample(filter));






    }

}
