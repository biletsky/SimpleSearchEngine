package stage4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class People {
    List<String> people = new ArrayList<>();

    public List<String> getPeople() {
        return people;
    }

    public void addPerson(String person) {
        people.add(person);
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public void addPeopleFromFile(String args) throws IOException {
        File file = new File(args);
        BufferedReader br=new BufferedReader(new FileReader(file));
        String st;
        while((st=br.readLine())!=null){
            people.add(st);
        }
        br.close();
    }


}


