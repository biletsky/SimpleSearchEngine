package stage6.command;

import stage6.People;
import java.util.Set;

public interface PeopleSelectionAlgorithm {

    String SEPARATOR = " ";

    Set<String> select(String query, People people);

}
