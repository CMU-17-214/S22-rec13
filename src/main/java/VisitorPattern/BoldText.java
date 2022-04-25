package VisitorPattern;

/**
 * class represent the bold text.
 */
public record BoldText(String text) implements DocumentPart {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}