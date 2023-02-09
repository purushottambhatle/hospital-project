package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Branch;
import hospital_project_dto.Hospital;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBranch(Branch branch1,int hospital_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital =entityManager.find(Hospital.class, hospital_id);
		
		Branch  list = entityManager.find(Branch.class, branch1.getId());
		List<Branch> listbBranchs = new ArrayList<Branch>();
		listbBranchs.add(branch1);
		
	    hospital.setBranches(listbBranchs);
		 
		entityTransaction.begin();
		if(hospital != null) {
	for(Branch l:listbBranchs) {
	
		entityManager.merge(l);
	    
		}
		entityManager.merge(hospital);
		entityTransaction.commit();

		}

	}

	public void updateBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2=entityManager.find(Branch.class, branch.getId());
		branch2.setId(branch.getId());
		branch2.setBname(branch.getBname());
		entityTransaction.begin();
		entityManager.merge(branch2);
		entityTransaction.commit();
	}

	public void deleteBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2=entityManager.find(Branch.class, branch.getId());
		branch2.setId(branch.getId());
		entityTransaction.begin();
		entityManager.remove(branch2);
		entityTransaction.commit();
	}

	

	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("SELECT b from Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}

	public void getBranchById(int bid) {
		EntityManager entityManager = getEntityManager();
		Branch branch2=entityManager.find(Branch.class, bid);
		branch2.setId(bid);
		System.out.println(branch2);
		
	}
}
