package factory.car.entity;

import java.rmi.server.UID;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	private UID id;
	private String brand;
	private Timestamp registration;
	private String country;
	private Timestamp created_at;
	private Timestamp last_updated;
	
	public Car() {
		
	}
	
	/**
	 * @param id
	 * @param brand
	 * @param registration
	 * @param country
	 * @param created_at
	 * @param last_updated
	 */
	public Car(UID id, String brand, Timestamp registration, String country, Timestamp created_at,
			Timestamp last_updated) {
		this.id = id;
		this.brand = brand;
		this.registration = registration;
		this.country = country;
		this.created_at = created_at;
		this.last_updated = last_updated;
	}
	public UID getId() {
		return id;
	}
	public void setId(UID id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Timestamp getRegistration() {
		return registration;
	}
	public void setRegistration(Timestamp registration) {
		this.registration = registration;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Timestamp last_updated) {
		this.last_updated = last_updated;
	}
	
	
}
