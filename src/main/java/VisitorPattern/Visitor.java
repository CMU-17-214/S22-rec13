package VisitorPattern;

/**
 * visitor interface, using method overloading to visit different type of document part.
 */
public interface Visitor {
    /**
     * visit the {@link BoldText} class and convert it to string.
     *
     * @param boldText the class to be visited
     * @return the string format of the class
     */
    String visit(BoldText boldText);

    /**
     * visit the {@link PlainText} class and convert it to string.
     *
     * @param plainText the class to be visited
     * @return the string format of the class
     */
    String visit(PlainText plainText);

    /**
     * visit the {@link Hyperlink} class and convert it to string.
     *
     * @param hyperlink the class to be visited
     * @return the string format of the class
     */
    String visit(Hyperlink hyperlink);

    /**
     * visit the {@link Document} class and convert it to string.
     *
     * @param document the class to be visited
     * @return the string format of the class
     */
    String visit(Document document);
}
