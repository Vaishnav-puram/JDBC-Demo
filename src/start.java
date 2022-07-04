import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import com.student.manage.Student;
import com.student.manage.StudentDao;
public class start {
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to student maangement app");
		while(true) {
			System.out.println("enter 1 to add student");
			System.out.println("enter 2 to display students");
			System.out.println("enter 3 to delete student");
			System.out.println("enetr 4 to exit");
			int x=Integer.parseInt(br.readLine());
			if(x==1) {
				System.out.println("Enter Student name:");
				String name=br.readLine();
				System.out.println("Enter Student phone:");
				long phone=Long.parseLong(br.readLine());
				System.out.println("Enter Student city:");
				String city=br.readLine();
				
				//create student object to store data
				Student st=new Student(name,phone,city);
				
				boolean result=StudentDao.insertStudentToDB(st);
				if(result) {
					System.out.println("student datails added successfully...");
					
				}
				else {
					System.out.println("something went wrong!!!!!");
				}
				System.out.println(st);
				
				
			}else if(x==2) {
				//show data
				StudentDao.showData();
				
				
			}else if(x==3) {
				//delete student 
				System.out.println("Enter student id:");
				int id=Integer.parseInt(br.readLine());
				boolean result1=StudentDao.deleteStudent(id);
				if(result1) {
					System.out.println("deleted!!!");
				}else {
					System.out.println("something went wrong!!!");
				}
			}else if(x==4) {
				
				break;
			}else {
				System.out.println("not a valid input!!!!");
			}
		}
		System.out.println("thakyou!!! bye.....");
	}
}
