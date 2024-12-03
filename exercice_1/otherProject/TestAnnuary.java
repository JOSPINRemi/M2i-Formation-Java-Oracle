public class TestAnnuary {
    public static void main(String[] args) {
        Annuary annuary = new Annuary();
        annuary.addPerson(new Person("John Doe", "0123456789"));
        annuary.addPerson(new Person("Jane Doe", "9876543210"));
        System.out.println(annuary.getAnnuary());
    }
}