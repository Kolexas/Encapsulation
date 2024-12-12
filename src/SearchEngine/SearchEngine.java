package SearchEngine;

public class SearchEngine {
    Searchable[] engine;

    public SearchEngine(int size) {
        engine = new Searchable[size];
    }

    public String[] search(String name) {
        String[] result = new String[5];
        int count = 0;
        for (Searchable searchable : engine) {
            if (searchable != null && searchable.getSearchTerm().contains(name)) {
                result[count++] = searchable.getStringRepresentation();
                if (count == 5) {
                    break;
                }
            }
        }
        return result;
    }

    public int findSpaceInEngine() {
        for (int i = 0; i < engine.length; i++) {
            if (engine[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addSearchable(Searchable searchable) {
        int i = findSpaceInEngine();
        if (i == -1) {
            throw new ArrayIndexOutOfBoundsException("Невозможно добавить в поиск");
        }
        engine[i] = searchable;
    }
}
