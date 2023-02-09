package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.Encounter;
import hospital_project_dto.MedicineOrder;

public class MedicineOrderDAO {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveMedicineOrder(MedicineOrder medicineOrder, Encounter encounter) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		  Encounter findencounter = eManager.find(Encounter.class, encounter.getId());

		List<MedicineOrder> medicineOrderList = new ArrayList<MedicineOrder>();
		medicineOrderList.add(medicineOrder);

		if (medicineOrderList != null) {
		eTransaction.begin();
		
		medicineOrder.setEncounter(findencounter);
		for (MedicineOrder m : medicineOrderList) {

			eManager.persist(medicineOrder);
			eManager.merge(findencounter);

			eTransaction.commit();
		  }
		}
	}

	                                                                           //MedicineOrder medicineOrder
	public void updateMedicineOrder(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
																				//medicineOrder.getMedId()
		MedicineOrder medicineOrder1 = entityManager.find(MedicineOrder.class, 1);

		entityTransaction.begin();

		if (medicineOrder1 != null) {
			medicineOrder1.setMedId(id);                      //medicineOrder.getMedId()
			medicineOrder1.setDname("maleria");                //medicineOrder.getDname()

			entityManager.merge(medicineOrder1);
			entityTransaction.commit();
			System.out.println("Updated successfully");

		} else {
			System.out.println("this MedicineOrder id is not present");
		}
		

	}

//	public void deleteMedicineOrder(int id) {
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		
//		MedicineOrder findMedicineOrder = entityManager.find(MedicineOrder.class,id);
//		Encounter find = entityManager.find(Encounter.class, id);
//		
//		 findMedicineOrder .setMedId(id);
//		 find.setId(id);
//		    entityTransaction.begin();
//		   
//			entityManager.remove( findMedicineOrder );
//			entityManager.remove(find);
//			entityTransaction.commit();
//			
//			System.out.println("Deleted successfully");
//	}
	

	public MedicineOrder getMedicineOrderById(int id) {
		EntityManager entityManager = getEntityManager();
		MedicineOrder medicineOrder = entityManager.find(MedicineOrder.class, id);
		System.out.println(medicineOrder);
		return medicineOrder;

	}

	public List<MedicineOrder> getAllMedicineOrder() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select m from MedicineOrder m");
		List<MedicineOrder> list = query.getResultList();
		System.out.println(list);
		return list;

	}

}