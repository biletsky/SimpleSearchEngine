package stage6;

import java.util.*;

public class SelectAnyPeople implements PeopleSelectionAlgorithm {
    @Override
    public Set<String> select(Map<String, ArrayList<Integer>> mapWords, String query, People people) {
        String[] keys = query.toUpperCase().split(SEPARATOR);
        Set<String> persons = new HashSet<>();
        for (String key : keys) {
            if (mapWords.containsKey(key)) {
                for (Integer i : mapWords.get(key)) {
                    persons.add(people.getPeopleList().get(i));
                }
            }
        }
        return persons;
    }
}
