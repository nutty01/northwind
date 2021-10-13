package demo.northwind.dataAccess.abstracts;

import demo.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    List<Product> getByCategoryIdIn(List categories);

    List<Product> findByProductNameContains(String productName);

    List<Product> findByProductNameStartsWith(String productName);

    //JPQL
    @Query("From Product where productName=:productName and categoryId=:categoryId")  //Product entity  //:productName is parameter
    List<Product> getByNameAndCategory(String productName, int categoryId);


}
