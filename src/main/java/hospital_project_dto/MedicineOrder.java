package hospital_project_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MedicineOrder {


	@Id
	private int medId;
	private String dname;
	private String disease;

	@ManyToOne
	private  Encounter encounter;

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		return "MedicineOrder [medId=" + medId + ", dname=" + dname + ", disease=" + disease + ", encounter="
				+ encounter + "]";
	}

	




}