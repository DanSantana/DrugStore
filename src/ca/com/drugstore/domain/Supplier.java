package ca.com.drugstore.domain;

public class Supplier {
	private Long idsuplier;
	private String description;
	
	public Long getIdsuplier() {
		return idsuplier;
	}
	public void setIdsuplier(Long idsuplier) {
		this.idsuplier = idsuplier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		String dataout = idsuplier + " - "+ description;
		return dataout;
	}

}
