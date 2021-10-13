package demo.northwind.business.abstracts;

import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List categories);

    DataResult<List<Product>> findByProductNameContains(String productName);

    DataResult<List<Product>> findByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
