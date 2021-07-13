package com.cg.user.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.user.domain.User;
import com.cg.user.service.UserService;
import com.cg.user.serviceimpl.UserServiceImpl;



public class MenuUtil {

	private UserService userService;
	Map<Integer, User> map;
	
	public MenuUtil()
	{
		userService = new UserServiceImpl();
	}
	
	public void start()
	{
		Scanner sc = new Scanner(System.in);
		int input;
		for(int i=0;i<1;)
		{
			showMenu();
			input = sc.nextInt();
			
			if(input==1)
			{
				User emp = getInput(sc);
				userService.createUser(emp);
			}
			if(input==2)
			{
			int sno=1;
			System.out.println("User List");	
			List<User> epm = userService.listUser();
			map = new HashMap<Integer, User>();
			for(User emp : epm)
			{
				map.put(sno, emp);
				sno++;
			}
			for(Map.Entry<Integer, User> m : map.entrySet())
			{
				System.out.println(m.getKey() +" "+m.getValue().getName()+" "+m.getValue().getCity()+" "+m.getValue().getDept());
			}
			}
			if(input==3)
			{
			User emp = getUpdate(sc);
			userService.updateUser(emp);
			}
			if(input==4)
			{
				int id=0;
				System.out.println("Enter Serial number to be deleted");
				input = sc.nextInt();
				for(Map.Entry<Integer, User> emp : map.entrySet())
				{
					if(input==emp.getKey())
					{
						id = emp.getValue().getId();
					}
				}
				userService.removeUser(id);
			}
		}
		
	}

	private User getInput(Scanner sc) {
		User emp = new User();
		System.out.println("Enter the name");
		emp.setName(sc.next());
		System.out.println("Enter Department");
		emp.setDept(sc.next());
		System.out.println("Enter the City");
		emp.setCity(sc.next());
		return emp;
	}

	private void showMenu() {
		System.out.println("Press 1 to insert data");
		System.out.println("Press 2 to view Records");
		System.out.println("Press 3 to update record");
		System.out.println("press 4 to delete data");
	}
	
	private User getUpdate(Scanner sc) {
		int input;
		User emp = new User();
		System.out.println("Enter serial number of the employee");
		input = sc.nextInt();
		for(Map.Entry<Integer, User> empl : map.entrySet())
		{
			if(empl.getKey()==input)
				emp.setId(empl.getValue().getId());
		}
		System.out.println("Enter the name");
		emp.setName(sc.next());
		System.out.println("Enter Department");
		emp.setDept(sc.next());
		System.out.println("Enter the City");
		emp.setCity(sc.next());
		return emp;
	}

}