package demo.northwind.business.concretes;

import demo.northwind.business.abstracts.ProductService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.core.utilities.results.SuccessDataResult;
import demo.northwind.core.utilities.results.SuccessResult;
import demo.northwind.repository.abstracts.ProductRepository;
import demo.northwind.model.concretes.Product;
import demo.northwind.model.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }



    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(),"Data listed");
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public Result deleteById(int id) {
        this.productRepository.deleteById(id);
        return new SuccessResult("Product deleted");
    }



    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductName(productName),"Data listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategory_CategoryIdIn(categories),"Data listed");
    }

    @Override
    public DataResult<List<Product> >findByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.findByProductNameContains(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> findByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.findByProductNameStartsWith(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByNameAndCategory_CategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productRepository.getProductWithCategoryDetails(),"Data listed");
    }
}
