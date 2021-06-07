package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    Product getByProductNameAndCategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
    List<Product> getByCategoryIdIn( List<Integer> categoryIds);

    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByProductNameAndCategory(String productName, int categoryId);
}
