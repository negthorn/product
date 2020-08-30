package app.neg.ecomm.product;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import app.neg.ecomm.category.CategoryCounter;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;


	public List<Product> findAll(
			Optional<String> orderBy, 
			Optional<String> direction, 
			Optional<Integer> pageNum,
			Optional<Integer> pageSize
		) {
		Direction sortDirection = Direction.fromOptionalString(direction.orElse("")).orElse(Direction.ASC);
		String sortProperty = orderBy.orElse("id");
		Sort sort = Sort.by(sortDirection, sortProperty);
		
		if(pageSize.isPresent()) {
			// goes through pagination and (optional/default) sorting
			Integer p = pageNum.orElse(1);
			int page = (p < 1) ? 1 : p;
			PageRequest pr = PageRequest.of(page - 1 , pageSize.get(), sort);
			return dao.findAll(pr).getContent();
		} else {
			//pageNum is ignored - goes only with sorting
			return dao.findAll(sort);			
		}
		
	}
	
	public List<Product> findAll() {
		return dao.findAll();
	}

	public Product findById(int id) {
		return dao.findById(id).orElse(null);
	}

	public Product update(Product p) {
		p.setDateLastModified(new Date());
		return dao.save(p);
	}

	public Product add(Product p) {
		return dao.save(p);
	}

	public Product delete(Product p) {
		dao.delete(p);
		return p;
	}

	public List<CategoryCounter> getProductCount() {
		return dao.findCategoryCount();
	}

}
