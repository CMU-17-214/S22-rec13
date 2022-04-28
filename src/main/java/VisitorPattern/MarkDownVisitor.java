package VisitorPattern;

/**
 * the visitor class for markdown. It can visite four kinds of classes
 * and transform it to string of markdown format.
 *
 * @author Yuzhe Guo
 */
public class MarkDownVisitor implements Visitor {

    @Override
    public String visit(BoldText boldText) {
        StringBuilder sb = new StringBuilder();
        sb.append("**").append(boldText.text()).append("**");
        return sb.toString();
    }

    @Override
    public String visit(PlainText plainText) {
        return plainText.text();
    }

    @Override
    public String visit(Hyperlink hyperlink) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(hyperlink.text()).append("]").append("(").append(hyperlink.url()).append(")");
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
