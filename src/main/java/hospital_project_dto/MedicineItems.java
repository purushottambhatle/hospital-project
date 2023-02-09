package hospital_project_dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedicineItems {

	@Id
	private int id;
	private String name;
	private double price;
	private int quantity;
	@ManyToOne
	private MedicineOrder medicineOrder;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MedicineOrder getMedicineOrder() {
		return medicineOrder;
	}
	public void setMedicineOrder(MedicineOrder medicineOrder) {
		this.medicineOrder = medicineOrder;
	}
	@Override
	public String toString() {
		return "MedicineItems [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", medicineOrder=" + medicineOrder + "]";
	}
	

	

}