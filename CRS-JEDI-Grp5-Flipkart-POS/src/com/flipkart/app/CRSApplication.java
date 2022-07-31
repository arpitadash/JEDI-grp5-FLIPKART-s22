package com.flipkart.app;
import com.flipkart.bean.*;
import com.flipkart.service.*;

public class CRSApplication {
	static boolean loggedin = false;
	Course course = new Course();
	Map<Integer, Course> map = new HashMap<String, course>();
    Scanner scanner = new Scanner(System.in);

	public static void main(String[]args) {

		CRSApplication crsApplication=new CRSApplication();
		crsApplication.createLoginPage();
	}

	public static void createLoginPage()
	{
        try
        {
            while(true)
            {
                System.out.println("\n\n----------Course Registration System---------\n\n");
                System.out.println("1. Login");
                System.out.println("2. Student Registration");
                System.out.println("3. Update password");
                System.out.println("4. Exit");
                System.out.println("Enter user input");

                int usercase;
                usercase= scanner.nextInt();
                if(usercase == 1){
                    loginUser();
                }
                else if(usercase ==2){
                    studentRegistration();
                }
                else if(usercase == 3){
                    updatePassword();
                }
                else{
                    scanner.close();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

	public void loginUser(){
        System.out.println("\n\n----------User Log In---------\n\n");
		String useremail,password;
		int role;
        try{
            System.out.println("Email:");
            useremail = scanner.next();
            System.out.println("Password:");
            password = scanner.next();
            System.out.println("Role:");
            System.out.println("1.Admin		2.Professor		3.Student");
            role = scanner.nextInt();

            while(role!=1 || role!=2 || role!=3)
            {
                System.out.println("***** Invalid Role please select correct role *****");
                System.out.println("Role:");
                System.out.println("1.Admin		2.Professor		3.Student");
                role = scanner.nextInt();
            }

            if(verifyUser(useremail,password,role)){
                loggedin = true;
            }
            else {
                System.out.println("Invalid User");
                loginUser();
            }

            if (loggedin) {
                switch (role) {
                    case 1:
                        System.out.println("\n\n----------Log In Successful as Admin---------\n\n");
                        System.out.println("Welcome " + username + " !!");
                        AdminCRSMenu adminMenu = new AdminCRSMenu();
                        adminMenu.createAdminMenu(useremail);
                        break;
                    case 2:
                        System.out.println("\n\n----------Log In Successful---------\n\n");
                        ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
                        professorMenu.createMenu();

                        break;
                    case 3:
                        System.out.println("\n\n----------Log In Successful---------\n\n");
                        StudentCRSMenu studentMenu=new StudentCRSMenu();
                        studentMenu.createMenu();
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

	}
    public static boolean verifyUser(String email, String pass, int role) throws IOException {
        File f = new File("../../../../resources/Sheet1.csv");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempA;
        while((line = br.readLine()) != null)
        {
            tempA = line.split(",");
            System.out.println(tempA[0]+email);
            System.out.println(tempA[1]+pass);
            System.out.println(tempA[2]+role);
            if(tempA[0].equals(email) && tempA[1].equals(pass) && Integer.parseInt(tempA[2]) == role) {
                return true;
            }
        }
        br.close();
        return false;
    }
}
