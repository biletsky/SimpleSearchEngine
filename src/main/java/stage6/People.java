package stage6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
}
