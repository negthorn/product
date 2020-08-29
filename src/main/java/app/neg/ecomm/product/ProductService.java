package app.neg.ecomm.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	public List<Product> findAll() {
		return dao.findAll();
	}

	public Product findById(int id) {
		return dao.findById(id).orElse(null);
	}

	public Product update(Product p) {
		return null;
	}

	public Product add(Product p) {
		return dao.save(p);
	}

	public Product delete(Product p) {
		dao.delete(p);
		return p;
	}

}
