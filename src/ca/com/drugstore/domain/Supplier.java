package ca.com.drugstore.domain;

public class Supplier {
	private Long idsupplier;
	private String description;
	
	public Long getIdsupplier() {
		return idsupplier;
	}
	public void setIdsupplier(Long idsuplier) {
		this.idsupplier = idsuplier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		String dataout = idsupplier + " - "+ description;
		return dataout;
	}

}
