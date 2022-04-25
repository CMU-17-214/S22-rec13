package VisitorPattern;

/**
 * the document part interface that can be converted to html or markdown.
 */
public interface DocumentPart {
    /**
     * accept different visitor to get the string of class.
     *
     * @param visitor visitor, can be html or markdown
     * @return string format of part
     */
    String accept(Visitor visitor);
}
