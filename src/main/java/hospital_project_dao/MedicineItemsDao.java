package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project_dto.MedicineItems;
import hospital_project_dto.MedicineOrder;

public class MedicineItemsDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveMedicineItems(MedicineItems medicineItems, MedicineOrder medicineOrder) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedicineOrder medicineorder = entityManager.find(MedicineOrder.class, medicineOrder.getMedId());

		List<MedicineItems> medicineItemsList = new ArrayList<MedicineItems>();
		medicineItemsList.add(medicineItems);

		for (MedicineItems m : medicineItemsList) {
			entityTransaction.begin();

			medicineItems.setMedicineOrder(medicineorder);
			entityManager.persist(medicineItems);
			entityManager.merge(medicineOrder);

			entityTransaction.commit();
		}
	}

	public void getMedicineItemsById(int id) {
		EntityManager entityManager = getEntityManager();
		MedicineItems find = entityManager.find(MedicineItems.class, id);
		System.out.println(find);

	}

	public void getAllMedicineItems() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select m from MedicineItems m");
		List resultList = query.getResultList();
		System.out.println(resultList);
		

	}

}
