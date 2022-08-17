package stage6;

import java.util.*;

public class SelectAllPeople implements PeopleSelectionAlgorithm {

    @Override
    public Set<String> select(Map<String, ArrayList<Integer>> mapWords, String query, People people) {
        String[] keys = query.toUpperCase().split(SEPARATOR);
        Set<String> persons = new HashSet<>();
        for (String key : keys) {
            if (mapWords.containsKey(key)) {
                for (int i : mapWords.get(key)) {
                    persons.add(people.getPeopleList().get(i));
                }
                persons.removeIf(per -> !per.contains(key));
            }
        }
        return persons;
    }
}