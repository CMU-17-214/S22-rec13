package VisitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * the class document that contains list of document part
 *
 * @author Yuzhe Guo
 */
public class Document implements DocumentPart {
    List<DocumentPart> parts;

    public Document() {
        this.parts = new ArrayList<>();
    }

    public Document(List<DocumentPart> parts) {
        this.parts = parts;
    }

    public void addDocPart(DocumentPart part) {
        this.parts.add(part);
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public List<DocumentPart> getParts() {
        return parts;
    }
}
