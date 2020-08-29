package app.neg.ecomm.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public List<Product> findAll(){
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Product findById(@RequestParam("id")int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Product add(Product p) {
		return service.add(p);
	}
	
	@PutMapping("{id}")
	public Product update(Product p) {
		return service.update(p);
	}
	
	@DeleteMapping
	public Product delete(Product p) {
		return service.delete(p);
	}
	
	
	
	
	
	
	
	

}