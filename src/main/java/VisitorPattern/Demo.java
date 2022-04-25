package VisitorPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * the class that use welcome to 17214/514 as an example to show the correctness
 * of the class implemented in VisitorPattern folder.
 *
 * @author Yuzhe Guo
 */
public class Demo {
    public static void main(String[] args) {
        // create document
        String text = "Welcome to ";
        String bold = "17514/214";
        String link = "https://cmu-17-214.github.io/s2022/";
        Document doc = new Document();
        doc.addDocPart(new PlainText(text));
        doc.addDocPart(new BoldText(bold));
        doc.addDocPart(new Hyperlink("(website)", link));

        writeFile(doc.toMarkDown(), "test.md");
        writeFile(doc.toHTML(), "test.html");
    }

    // helper method to write to file.
    public static void writeFile(String content, String fileName) {
        Writer writer = null;
        try {
            String newPath = System.getProperty("user.dir") + "/" + fileName;
            System.out.println(newPath);
            writer = new BufferedWriter(new FileWriter(newPath));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileType = fileName.split("\\.")[1];
        System.out.println("Finish writing the content to " + fileType);
    }
}
