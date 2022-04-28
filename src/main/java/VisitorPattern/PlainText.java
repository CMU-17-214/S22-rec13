package VisitorPattern;

/**
 * class represent text method.
 */
public record PlainText(String text) implements DocumentPart {

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
