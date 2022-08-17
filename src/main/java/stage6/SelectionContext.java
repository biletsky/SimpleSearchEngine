package stage6;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SelectionContext {

    private PeopleSelectionAlgorithm algorithm;

    public void setAlgorithm(PeopleSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Set<String> selectPeople(Map<String, ArrayList<Integer>> mapWords, String query, People people) {
        return algorithm.select(mapWords, query, people);
    }

    public void printPeople(Set<String> persons) {
        System.out.println(persons.size() + " persons found:");
        for (String person : persons) {
            System.out.println(person);
        }
    }
}
