package stage6.command.commands;

import stage6.People;
import stage6.command.PeopleSelectionAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class SelectAllPeople implements PeopleSelectionAlgorithm {

    @Override
    public Set<String> select(String query, People people) {
        String[] keys = query.toUpperCase().split(SEPARATOR);
        Set<String> persons = new HashSet<>();
        for (String key : keys) {
            if (people.mapWords().containsKey(key)) {
                for (int i : people.mapWords().get(key)) {
                    persons.add(people.getPeopleList().get(i));
                }
            }
        }
        for (String key : keys) {
            persons.removeIf(per -> !per.toUpperCase().contains(key));
        }
        return persons;
    }
}