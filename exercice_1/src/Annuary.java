import java.util.ArrayList;
import java.util.List;

public class Annuary {
    private List<Person> persons;

    public Annuary(){
        this.persons = new ArrayList<>();
    }

    public List<Person> getAnnuary(){
        return this.persons;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }
}