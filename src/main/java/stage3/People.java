package stage3;

import java.util.ArrayList;
import java.util.List;

public class People {
    List<String> people = new ArrayList<>();
    public List<String> getPeople() {
        return people;
    }

    public void addPerson(String person){
        people.add(person);
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }
}
