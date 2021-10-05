package com.te.student.dao;

import java.util.Collections;
import java.util.Scanner;

import com.te.hibernate.exception.InvaidInputProvided;
import com.te.student.curdoperation.StudentAction;

public class StudentDao {

	public static void main(String[] args) {
		boolean b = false;
		StudentAction studentAction = new StudentAction();
		Scanner scanner = new Scanner(System.in);
		String value = null;

		do {
			System.out.println("Press 1 to see all data");
			System.out.println("Press 2 to see any Particular Data");
			System.out.println("Press 3 to Update any Particuar Data");
			System.out.println("Press 4 to Delete Data");

			int Choice = scanner.nextInt();

			switch (Choice) {
			case 1:
				studentAction.selectAllData();

				break;

			case 2:
				studentAction.selectParticularData();

				break;

			case 3:
				studentAction.updateData();

				break;

			case 4:
				studentAction.deleteData();

				break;
			default:
				try {
					throw new InvaidInputProvided("Please Enter Valid Option");

				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
			}
			System.out.println("Do You Want to Continue - Yes / No");
			value = scanner.next();

		} while (value.equalsIgnoreCase("yes"));

	}

}
