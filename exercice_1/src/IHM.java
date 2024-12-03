import java.util.Scanner;

public class IHM {
    private Scanner input;
    private Annuary annuary;

    public IHM(){
        input = new Scanner(System.in);
        annuary = new Annuary();
    }

    public void start(){
        int choice;
        do {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Lister les contacts");
            System.out.println("4. Quitter");
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1 -> addContact();
                case 2 -> {
                    System.out.println("Annuary :");
                    System.out.println(annuary.getAnnuary());
                }
            }
        }while (choice != 4);
    }

    public void addContact(){
        String contactName;
        String contactPhoneNumber;
        System.out.println("Enter contact name : ");
        contactName = input.nextLine();
        System.out.println("Enter contact phone number : ");
        contactPhoneNumber = input.nextLine();
        Person contact = new Person(contactName, contactPhoneNumber);
        annuary.addPerson(contact);
        System.out.println("Contact added successfully");
    }
}