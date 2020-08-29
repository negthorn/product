package app.neg.ecomm.product;

import java.util.List;

public class ProductList {
	List<Product> products;
	int totalRecords;
	
	public ProductList(List<Product> plist) {
		this.products = plist;
		this.totalRecords = plist.size();
	}

	public List<Product> getProducts() {
		return products;
	}

	public int getTotalRecords() {
		return totalRecords;
	}
	
	
}
