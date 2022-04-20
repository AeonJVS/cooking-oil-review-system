package cookingOilReviewSystem.Project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cookingOilReviewSystem.Project.domain.OilType;

@Entity
public class Oil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String manufacturer;
	private int volume;
	private String countryOfOrigin;
	private Double rate;
	private String commentary;
	
    @ManyToOne
    @JsonIgnoreProperties ("oils") 
    @JoinColumn(name = "typeId")
    private OilType oilType;
	
    
    // ADD OILTYPE !
	public Oil() {
		super();
		this.id = null;
		this.name = null;
		this.manufacturer = null;
		this.volume = 0;
		this.countryOfOrigin = null;
		this.rate = 0.0;
		this.commentary = null;
		this.oilType = null;
	}
	
	public Oil(String name, String manufacturer, int volume, String countryOfOrigin, Double rate, String commentary, OilType oilType) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.volume = volume;
		this.countryOfOrigin = countryOfOrigin;
		this.rate = rate;
		this.commentary = commentary;
		this.oilType = oilType;
	}
	
	public Oil(Long id, String name, String manufacturer, int volume, String countryOfOrigin, Double rate, String commentary, OilType oilType) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.volume = volume;
		this.countryOfOrigin = countryOfOrigin;
		this.rate = rate;
		this.commentary = commentary;
		this.oilType = oilType;
	}
	
	// Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getVolume() {
		return volume;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public Double getRate() {
		return rate;
	}

	public String getCommentary() {
		return commentary;
	}

	public OilType getOilType() {
		return oilType;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public void setOilType(OilType oilType) {
		this.oilType = oilType;
	}
	
	// ToString
	@Override
	public String toString() {
		if (this.oilType != null)
			return "Oil [id=" + id + ", name=" + name+ ",  manufacturer=" + manufacturer + ", volume=" + volume + ", countryOfOrigin=" + countryOfOrigin
					+ ",  rate=" + rate + "commentary=" + commentary + "oilType =" + this.getOilType() + "]";		
		else
			return "Oil [id=" + id + ", name=" + name+ ",  manufacturer=" + manufacturer + ", volume=" + volume + ", countryOfOrigin=" + countryOfOrigin
					+ ",  rate=" + rate + "commentary=" + commentary + "]";
	}
}