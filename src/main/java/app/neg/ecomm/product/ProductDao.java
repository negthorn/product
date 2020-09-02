package app.neg.ecomm.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.neg.ecomm.category.CategoryCounter;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p.category as category, count(p.category) as productsAvailable FROM Product p GROUP BY p.category")
	public List<CategoryCounter> findCategoryCount();
		
	@Transactional 
	@Modifying
	@Query("UPDATE Product p SET p.dateLastModified = now(), p.quantity = p.quantity - ?2 WHERE p.id = ?1")
	public void orderProduct(int id, int items);
	
}
