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

    @Override
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        for (DocumentPart part : parts) {
            sb.append(part.toHTML());
        }
        return sb.toString();
    }

    @Override
    public String toMarkDown() {
        StringBuilder sb = new StringBuilder();
        for (DocumentPart part : parts) {
            sb.append(part.toMarkDown());
        }
        return sb.toString();
    }

    public void addDocPart(DocumentPart part) {
        this.parts.add(part);
    }
}
