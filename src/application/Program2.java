package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1: findById ======");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: findAll =====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: insert =====");
		Department obj = new Department(null,"Car");
		departmentDao.insert(obj);
		System.out.println("Inserted! New id = " + obj.getId());
		
		System.out.println("\n=== TEST 4: update =====");
		Department dep = departmentDao.findById(3);
		dep.setName("Smartphone");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: seller delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
}