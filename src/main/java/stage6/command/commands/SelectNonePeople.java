package stage6.command.commands;

import stage6.People;
import stage6.command.PeopleSelectionAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class SelectNonePeople implements PeopleSelectionAlgorithm {
    @Override
    public Set<String> select(String query, People people) {
        String[] keys = query.toUpperCase().split(SEPARATOR);
        Set<String> persons = new HashSet<>(people.getPeopleList());
        for (String key : keys) {
            if (people.mapWords().containsKey(key)) {
                for (Integer i : people.mapWords().get(key)) {
                    persons.remove(people.getPeopleList().get(i));
                }
            }
        }
        return persons;
    }
}
