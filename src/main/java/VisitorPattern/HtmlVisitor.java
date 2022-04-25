package VisitorPattern;

/**
 * the implementation of html visitor. It can visit four kinds of
 * class and transform the class to html format of string.
 *
 * @author Yuzhe Guo
 */
public class HtmlVisitor implements Visitor {
    @Override
    public String visit(BoldText boldText) {
        StringBuilder sb = new StringBuilder();
        sb.append("<b>").append(boldText.text()).append("</b>");
        return sb.toString();
    }

    @Override
    public String visit(PlainText plainText) {
        return plainText.text();
    }

    @Override
    public String visit(Hyperlink hyperlink) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"").append(hyperlink.url()).append("\">").append(hyperlink.text()).append("</a>");
        return sb.toString();
    }

    @Override
    public String visit(Document document) {
        StringBuilder sb = new StringBuilder();
        for (DocumentPart part : document.getParts()) {
            sb.append(part.accept(this));
        }
        return sb.toString();
    }
}
