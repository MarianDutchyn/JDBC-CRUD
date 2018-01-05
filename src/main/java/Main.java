import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean exit = true;

        while (exit != false){
            System.out.println("1 => Add new User");
            System.out.println("2 => Show all Users");
            System.out.println("3 => Edit a User");
            System.out.println("4 => Delete a User");
            System.out.println("5 => Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.next());

            switch (choice){
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter age");
                    int age = Integer.parseInt(scanner.next());
                    App.addUser(name, age);
                    break;

                case 2:
                    System.out.println("List of Users:");
                    App.showUsers();
                    break;

                case 3:
                    System.out.println("Edit a User");
                    String newname = scanner.next();
                    App.editUser(newname);
                    break;

                case 4:
                    System.out.println("Delete a User by name! \n Enter name");
                    String delete = scanner.next();
                    App.deleteUser(delete);
                    break;

                case 5:
                    exit = false;
                    System.out.println("Exit");
                    break;
            }

        }


    }
}
