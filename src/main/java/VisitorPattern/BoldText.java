package VisitorPattern;

/**
 * class represent the bold text.
 */
public record BoldText(String text) implements DocumentPart {

    @Override
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<b>").append(this.text).append("</b>");
        return sb.toString();
    }

    @Override
    public String toMarkDown() {
        StringBuilder sb = new StringBuilder();
        sb.append("**").append(this.text).append("**");
        return sb.toString();
    }
}
