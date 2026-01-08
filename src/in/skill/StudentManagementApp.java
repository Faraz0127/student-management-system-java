package in.skill;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManagementApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin("Teacher");
		
		ArrayList<Student> studentList = new ArrayList<>();
		
		while(true) {
			admin.showMenu();
			
			int choice;
			try {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			}catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
                continue;
			}
			
			switch(choice){
				case 1:
					try {
					System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    boolean exists = false;
                    for (Student st : studentList) {
                        if (st.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Student ID already exists! Use a unique ID.");
                        break;
                    }
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    
                    if (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("Name must contain only letters!");
                        break;
                    }

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    
                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100!");
                        break;
                    }
                    
                    studentList.add(new Student(id, name, marks));
                    System.out.println("Student Added Successfully!");
					
					}catch (InputMismatchException e) {
                        System.out.println("Invalid input format!");
                        sc.nextLine();
                    }
                    break;
                    
				case 2:
					if (studentList.isEmpty()) { 
	                        System.out.println("No Student Found");
	                    } else {
	                        for (Student st : studentList) { 
	                            st.display();
	                        }
	                    }
					break;
					
				case 3:
					try {
					System.out.print("Enter Student ID to Update: ");
                    int searchId = sc.nextInt();
                    boolean found = false; 
                    for (Student st : studentList) { 
                        if (st.getId() == searchId) { 
                            System.out.print("Enter New Marks: ");
                            int newMarks = sc.nextInt();
                            
                            if (newMarks < 0 || newMarks > 100) {
                                System.out.println("Marks must be between 0 and 100!");
                                break;
                            }

                            st.setMarks(newMarks); 
                            System.out.println("Marks Updated!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student Not Found");
					}catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
					break;
					
				case 4: // Delete Student
					try {
				    System.out.print("Enter Student ID to Delete: ");
				    int deleteId = sc.nextInt();

				    Iterator<Student> it = studentList.iterator();
			        boolean deleted = false;

			        while (it.hasNext()) {
			            if (it.next().getId() == deleteId) {
			                it.remove();
			                System.out.println("Student Deleted Successfully!");
			                deleted = true;
			                break;
			            }
			        }

			        if (!deleted) {
			            System.out.println("Student Not Found");
			        }

			    } catch (InputMismatchException e) {
			        System.out.println("Invalid input!");
			        sc.nextLine();
			    }
				    break;

					
				case 5:
					System.out.println("Exit Successfully.");
					sc.close(); 
					System.exit(0);
					break;
					
				default :
					System.out.println("Invalid Choice");
					break;
			}
		}
	}

}
