package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: department findAll ===");
		
		List<Department> list = depDao.findAll();
		for(Department obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: department insert ===");
		
		Department newDepartment = new Department(null, "Music");
		depDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4: department update ===");
	
		dep = depDao.findById(6);
		dep.setName("Food");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 5: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
	}

}
