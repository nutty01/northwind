package demo.northwind.repository.abstracts;

import demo.northwind.model.concretes.Product;
import demo.northwind.model.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getById(int id);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List categories);

    List<Product> findByProductNameContains(String productName);

    List<Product> findByProductNameStartsWith(String productName);

    //JPQL
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")  //Product entity  //:productName is parameter
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);

    @Query("Select new demo.northwind.model.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();



    //@Modifying
    //@Query("UPDATE Product p SET p.productName = :productName WHERE p.id = :id")
    //String updateProductName(@Param("id") int id, @Param("productName") String productName);




}
