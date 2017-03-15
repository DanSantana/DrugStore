package ca.com.drugstore.domain;

public class Product {

	private Long code;
	private String description;
	private Long quanty;
	private Double price;	
	private Supplier supplier;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getQuanty() {
		return quanty;
	}
	public void setQuanty(Long quanty) {
		this.quanty = quanty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}
