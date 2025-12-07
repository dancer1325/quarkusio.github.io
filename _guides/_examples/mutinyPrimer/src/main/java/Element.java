// Chemical periodical elements
public class Element {

    public String name;
    public String symbol;
    public int position;        // position | periodical table elements

    public Element(String name, String symbol, int position) {
        this.name = name;
        this.symbol = symbol;
        this.position = position;
    }

    public Element() {
        // Use by JSON mappers
    }
}
