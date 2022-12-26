import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import stage6.People;
import stage6.command.SelectionContext;
import stage6.command.commands.SelectAllPeople;
import stage6.command.commands.SelectAnyPeople;
import stage6.command.commands.SelectNonePeople;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleSearchEngineTests {
    SelectionContext selectionContext;
    People people;
    @BeforeAll
    public void init() throws IOException {
        selectionContext = new SelectionContext();
        people = new People();
        people.addPeopleFromFile("src/main/resources/data.txt");
    }

    @Test
    public void selectAllPeopleTest() {
       selectionContext.setAlgorithm(new SelectAllPeople());
       assertEquals("[Erick Harrington harrington@gmail.com]", selectionContext.selectPeople("Harrington Erick", people).toString());
    }

    @Test
    public void selectAnyPeopleTest() {
        selectionContext.setAlgorithm(new SelectAnyPeople());
        assertEquals("[Erick Harrington harrington@gmail.com, Erick Burgess]", selectionContext.selectPeople("Harrington Erick", people).toString());
    }

    @Test
    public void selectNonePeopleTest() {
        selectionContext.setAlgorithm(new SelectNonePeople());
        assertEquals("[Rene Webb webb@gmail.com, Myrtle Medina, Katie Jacobs]", selectionContext.selectPeople("djo@gmail.com ERICK", people).toString());
    }
}
