package hospital_project_dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long pincode;
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", pincode=" + pincode + "]";
	}
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
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	


}