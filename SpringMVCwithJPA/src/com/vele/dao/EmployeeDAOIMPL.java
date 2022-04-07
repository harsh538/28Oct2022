package com.vele.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vele.businessbean.Employeebean;
import com.vele.entity.EmployeeEntity;
@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class EmployeeDAOIMPL implements EmployeeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addEmployee(Employeebean employeebean) throws Exception {
		Integer id=0;
		EmployeeEntity ee = convertBeanToEntity(employeebean);
		try {
		em.persist(ee);
		
		id=ee.getId();
		}catch (Exception e) {
			System.out.println(new Exception("gafla in persist method"));
		}
		return id;
	}

	@Override
	public Employeebean getEmployeeById(int id) throws Exception {
		EmployeeEntity employeeEntity = em.find(EmployeeEntity.class, id);
		Employeebean employeebean = convertEntityToBean(employeeEntity);
		return employeebean;
	}

	@Override
	public List<Employeebean> getEmployeeDetails() throws Exception {

		List<Employeebean> list = new ArrayList<>();

		List<EmployeeEntity> listee = em.createQuery("from EmployeeEntity").getResultList();

		for (EmployeeEntity employeeEntity : listee) {
			Employeebean employeebean = new Employeebean();
			employeebean = convertEntityToBean(employeeEntity);
			list.add(employeebean);
		}
		return list;
	}

	public static EmployeeEntity convertBeanToEntity(Employeebean employeebean) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeebean, employeeEntity);
		return employeeEntity;

	}

	public static Employeebean convertEntityToBean(EmployeeEntity employeeEntity) {
		Employeebean employeebean = new Employeebean();
		BeanUtils.copyProperties(employeeEntity, employeebean);
		return employeebean;
	}

}
