package app.neg.ecomm.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="category", nullable = false)
	private String category = "Miscellaneous";
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="date_created",  nullable = false, insertable = false)
	private Date dateCreated = new Date();
	
	@Column(name="date_last_modified", nullable = false)
	private Date dateLastModified = new Date();
	
//	public Product() {
//		this.dateCreated = new Date();
//		this.dateLastModified = new Date();
//	}
//	
//	public Product(
//			@JsonProperty("name") String name,
//			@JsonProperty("category") String category,
//			@JsonProperty("description") String description, 
//			@JsonProperty("quantity") int quantity) {
//		this();
//		this.name = name;
//		this.category = category;
//		this.description = description;
//		this.quantity = quantity;
//	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateLastModified() {
		return dateLastModified;
	}
	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	@Override
	public String toString() {
		return String.format("Product:{id: %d, name: %s, cat: %s, descr:%s, qty:%d, add:%s, mod:%s }", 
					this.id, this.name, this.category, this.description,
					this.quantity, this.dateCreated, this.dateLastModified);
	}
	
	
}
