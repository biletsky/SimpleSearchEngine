package stage6;

import java.util.ArrayList;

import java.util.Map;
import java.util.Set;

public interface PeopleSelectionAlgorithm {

    String SEPARATOR = " ";

    Set<String> select(Map<String, ArrayList<Integer>> mapWords, String query, People people);

}
