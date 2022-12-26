package stage6.command;

import stage6.People;
import java.util.Set;

public class SelectionContext {

    private PeopleSelectionAlgorithm algorithm;

    public void setAlgorithm(PeopleSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Set<String> selectPeople(String query, People people) {
        return algorithm.select(query, people);
    }

    public void printPeople(Set<String> persons) {
        System.out.println(persons.size() + " persons found:");
        for (String person : persons) {
            System.out.println(person);
        }
    }
}
