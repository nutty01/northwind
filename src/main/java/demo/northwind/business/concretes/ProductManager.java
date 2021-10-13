package demo.northwind.business.concretes;

import demo.northwind.business.abstracts.ProductService;
import demo.northwind.core.utilities.results.DataResult;
import demo.northwind.core.utilities.results.Result;
import demo.northwind.core.utilities.results.SuccessDataResult;
import demo.northwind.core.utilities.results.SuccessResult;
import demo.northwind.dataAccess.abstracts.ProductDao;
import demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }



    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data listed");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIdIn(categories),"Data listed");
    }

    @Override
    public DataResult<List<Product>> findByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.findByProductNameContains(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> findByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.findByProductNameStartsWith(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data listed");
    }
}
