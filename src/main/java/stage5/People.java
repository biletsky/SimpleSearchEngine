package stage5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class People {

    private final ArrayList<String> peopleList = new ArrayList<>();

    public ArrayList<String> getPeopleList() {
        return peopleList;
    }

    public void addPeopleFromFile(String args) throws IOException {
        File file = new File(args);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String person;
        while ((person = bufferedReader.readLine()) != null) {
            peopleList.add(person);
        }
        bufferedReader.close();
    }

    Map<String, ArrayList<Integer>> mapWords() {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for (String person : peopleList) {
            String[] words = person.split(" +");
            for (String word : words) {
                word = word.toUpperCase();
                if (map.containsKey(word)) {
                    map.get(word).add(i);
                    map.put(word, map.get(word));
                } else {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i);
                    map.put(word, arrayList);
                }
            }
            i++;
        }
        return map;
    }
}
