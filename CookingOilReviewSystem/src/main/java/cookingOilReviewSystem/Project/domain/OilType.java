package cookingOilReviewSystem.Project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cookingOilReviewSystem.Project.domain.Oil;

@Entity
public class OilType {
	@Id // primary_key for database
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "oilType")
    //@JsonIgnore
	@JsonIgnoreProperties("oilType")
	private List<Oil> oils;
	
	public OilType() {}
	
	public OilType(String name) {
		super();
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public String getName() {
		return name;
	}

	public List<Oil> getOils() {
		return oils;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOils(List<Oil> oils) {
		this.oils = oils;
	}

	@Override
	public String toString() {
		return "OilType [typeId=" + typeId + ", name=" + name + "]";
	}

	
	
}
