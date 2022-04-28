package VisitorPattern;

/**
 * class represent text with hyperlink.
 */
public record Hyperlink(String text, String url) implements DocumentPart {

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}