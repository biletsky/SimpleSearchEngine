package stage6;

import java.util.*;

public class SelectNonePeople implements PeopleSelectionAlgorithm {
    @Override
    public Set<String> select(Map<String, ArrayList<Integer>> mapWords, String query, People people) {
        String[] keys = query.toUpperCase().split(SEPARATOR);
        Set<String> persons = new HashSet<>(people.getPeopleList());
        for (String key : keys) {
            if (mapWords.containsKey(key)) {
                for (Integer i : mapWords.get(key)) {
                    persons.remove(people.getPeopleList().get(i));
                }
            }
        }
        return persons;
    }
}
