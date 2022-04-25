package VisitorPattern;

/**
 * class represent text method.
 */
public record PlainText(String text) implements DocumentPart {
    @Override
    public String toHTML() {
        return text;
    }

    @Override
    public String toMarkDown() {
        return text;
    }
}
