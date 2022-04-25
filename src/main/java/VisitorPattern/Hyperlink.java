package VisitorPattern;

/**
 * class represent text with hyperlink.
 */
public record Hyperlink(String text, String url) implements DocumentPart {

    @Override
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"").append(this.url).append("\">").append(this.text).append("</a>");
        return sb.toString();
    }

    @Override
    public String toMarkDown() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.text).append("]").append("(").append(this.url).append(")");
        return sb.toString();
    }
}
