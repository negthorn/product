package app.neg.ecomm.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ProductList findAll(
			@RequestParam("orderBy") Optional<String> orderBy,
			@RequestParam("direction") Optional<String> direction,
			@RequestParam("page") Optional<Integer> pageNum,
			@RequestParam("pageSize") Optional<Integer> pageSize
			){
		return new ProductList(service.findAll(orderBy, direction, pageNum, pageSize));
	}
	
	@GetMapping(path = "{id}")
	public Product findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Product add(@RequestBody Product p) {
		return service.add(p);
	}
	
	@PostMapping(path = "{id}/order/{count}")
	public Product orderProduct(@PathVariable("id") int id, @PathVariable("count") int count) {
		Product product = service.findById(id);
		
	//TODO ... 
//		service.add(product);
		return product;
	}
	
	@PutMapping(path = "{id}")
	public Product update(@RequestBody Product p) {
		return service.update(p);
	}
	
	@DeleteMapping
	public Product delete(@RequestBody Product p) {
		return service.delete(p);
	}

}
