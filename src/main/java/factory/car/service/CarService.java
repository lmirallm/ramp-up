package factory.car.service;

import java.rmi.server.UID;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import factory.car.entity.Car;

@Stateless
public class CarService {

	@PersistenceContext(unitName = "pc_em")
	private EntityManager em;

	public List<Car> getCars() {
		return em.createQuery("SELECT c FROM car c").getResultList();
	}

	public Car getCar(UID id) {
		return em.find(Car.class, id);
	}

	public boolean createCar(Car user_car) {
		em.persist(user_car);
		em.flush();
		if (em.find(Car.class, user_car.getId()) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateCar(Car user_car) {
		if (em.find(Car.class, user_car.getId()) != null) {
			em.merge(user_car);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteCar(UID id) {
		if (em.find(Car.class, id) != null) {
			em.remove(id);
			return true;
		} else {
			return false;
		}
	}
}
