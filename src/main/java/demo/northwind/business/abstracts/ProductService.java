package demo.northwind.business.abstracts;

import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.entities.concretes.Product;
import demo.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    Result add(Product product);

    Result deleteById(int id);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List categories);

    DataResult<List<Product>> findByProductNameContains(String productName);

    DataResult<List<Product>> findByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
