package stage6;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.search(args[1]);
    }
}
