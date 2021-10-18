package demo.northwind.api;

import demo.northwind.business.abstracts.ProductService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.entities.concretes.Product;
import demo.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
    return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @DeleteMapping("/deletebyid/{id}")
    public Result deleteById(@PathVariable("id") int id){
        return this.productService.deleteById(id);
    }

    @GetMapping("/getbyproductname")
    public DataResult<Product> getByProductName(@RequestParam String productName){ //checks the productName parameters
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getbyproductnameandcategoryid")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/findbyproductnamecontains")
    public DataResult<List<Product>> findByProductNameContains(@RequestParam String productName){
        return this.productService.findByProductNameContains(productName);
    }

    @GetMapping("/getproductwithcategorydetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }
}
