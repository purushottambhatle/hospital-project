package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Branch;
import hospital_project_dto.Encounter;
import hospital_project_dto.Person;

public class EncounterDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
                                                     
	public void saveEncounter(Encounter encounter, int person_id,int branch_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, person_id);
		
		ArrayList<Encounter> arrayList= new ArrayList<Encounter>();
		arrayList.add(encounter);
		person.setEncounter(arrayList);
		      

		Branch branch = entityManager.find(Branch.class, branch_id);  
		ArrayList<Branch> arrayListBranch = new ArrayList<Branch>();
		
        encounter.setBranchList(arrayListBranch);
	   
        
        	entityTransaction.begin();
			entityManager.persist(person);  
            for(Encounter p:arrayList) {
			entityManager.persist(p);	
			 entityManager.merge(branch);
            }
           
            entityTransaction.commit();
	}
	
	public void updateEncounter(int id, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter1 = entityManager.find(Encounter.class, id);
		if (encounter1 != null) {
			encounter.setId(id);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			System.out.println("updated successfully");
		} else {
			System.out.println("not found");
		}

	}

	public void deleteEncounter(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			System.out.println("deleted successfully");
		} else {
			System.out.println("not found");
		}
	}

	public void fetchById(int id) {
		EntityManager entityManager = getEntityManager();
		Encounter encounter = entityManager.find(Encounter.class, id);
		System.out.println(encounter);
		System.out.println("fetched successfully");
	}

	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Encounter e");
		List<Encounter> list = query.getResultList();
		System.out.println(list);
		System.out.println("fetched successfully");
	}

}