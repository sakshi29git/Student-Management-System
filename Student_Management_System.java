import java.util.Scanner; // import Scanner class to take user input


public class Student_Management_System //class will manage data of student and user can easily add new data, update data and also can delete data by given roll number as a input. At last list of student information will be display.
{
	//declare instance variable
    int roll, std;
    String name;
	char div;
    static String school;

    Student_Management_System(Scanner sc) { // parameterized constructor to take input for new student details
        System.out.println("Enter Details: ");
        System.out.println("Name: ");
        name = sc.next();
        System.out.println("Roll No: ");
        roll = sc.nextInt();
        System.out.println("Std: ");
        std = sc.nextInt();
       System.out.println("Division(A/B/C/D):");
        div = sc.next().charAt(0);
        if (Character.isLetter(div)) {
            System.out.println("You have entered the right division");
        }

        else {
        	System.out.println("Wrong divison or numberic value");
        	return;
        }
        System.out.println("School Name: ");
        school = sc.next();
    }

    void update(Scanner sc) { // method to update student information based on given roll number
        System.out.println("Enter roll no");
        int n = sc.nextInt();
        if (this.roll == n) {
            System.out.println("Enter new details");
            System.out.println("Name: ");
            name = sc.next();
            System.out.println("Roll No: ");
            roll = sc.nextInt();
            System.out.println("Std: ");
            std = sc.nextInt();
            System.out.println("Division: ");
            div = sc.next().charAt(0);
            if (Character.isLetter(div)) {
                System.out.println("You have entered the right division");
            }
            else {
            	System.out.println("Wrong divison or numberic value");
            	return;
            }
            System.out.println("School Name: ");
            school = sc.next();
        } else {
            System.out.println("Sorry can't find details");
        }
    }

    void delete(Scanner sc) {	// method to delete student information based on given roll number
        System.out.println("Enter roll no: ");
        int n = sc.nextInt();
        if (this.roll == n) {
            this.name = null;
            this.roll = 0;
            this.div = 0;
            this.std = 0;
            this.school = null;
            System.out.println("Deleted information of roll no " + n + " sucessfully");
        } else {
            System.out.println("Sorry can't find details");
        }
    }

    void disp() {	// method to display student information based on given roll number
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Roll no: " + roll);
        System.out.println("Div: " + div);
        System.out.println("Std: " + std);
        System.out.println("School Name: " + school);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n,count;
        Student_Management_System[] obj = new Student_Management_System[100]; // creating array of object of student_constructors class
        count=0;
       
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. All Details");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            //User menu, user can choice any option any perform particular task of student information. If user enter 5, system will stop.
            switch (choice) {
                case 1:
                    System.out.println("Add new information");
                    System.out.print("How many students info you want to add: ");
                    n = sc.nextInt();
                    for (i = 0; i < n; i++) {
                        obj[i] = new Student_Management_System(sc);
                    }
                    break;

                case 2:
                    System.out.println("Update information:");
                    int rollToUpdate = sc.nextInt();
                    for (i = 0; i < obj.length; i++) {
                        if (obj[i] != null && obj[i].roll == rollToUpdate) {
                            obj[i].update(sc);
                            break; // Exit loop after updating
                        }
                    }
                    if (i == obj.length) {
                        System.out.println("Student not found");
                    }
                    break;

                case 3:
                    System.out.println("Delete information");
                    int rollToDelete = sc.nextInt();
                    for (i = 0; i < obj.length; i++) {
                        if (obj[i] != null && obj[i].roll == rollToDelete) {
                            obj[i].delete(sc);
                            break; // Exit loop after deleting
                        }
                    }
                    if (i == obj.length) {
                        System.out.println("Student not found");
                    }
                    break;

                case 4:
                    System.out.println("All Details:");
                    for (i = 0; i < obj.length; i++) {
                        if (obj[i] != null) {
                            obj[i].disp();
                            count++;
                            
                            System.out.println();
                        }

                    }
                    if(count==0)
                    {
                        System.out.println("Sorry...List is empty. Add new details");
                    }
                    else{

                        System.out.println("Total students: " + count);
                    }
                   
                    break;

                case 5:
                    System.out.println("Program has been stoped...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }

}
