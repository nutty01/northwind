package demo.northwind.api;

import demo.northwind.business.abstracts.ProductService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.entities.concretes.Product;
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

    @PostMapping("add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    

}
