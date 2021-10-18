package demo.northwind.dataAccess.abstracts;

import demo.northwind.entities.concretes.Product;
import demo.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List categories);

    List<Product> findByProductNameContains(String productName);

    List<Product> findByProductNameStartsWith(String productName);

    //JPQL
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")  //Product entity  //:productName is parameter
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);

    @Query("Select new demo.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();




}
