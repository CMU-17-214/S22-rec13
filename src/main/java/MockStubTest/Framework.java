package MockStubTest;

import java.time.LocalDate;

/**
 * the framework class with only updateRecord method implemented.
 * @author Yuzhe Guo
 */
public class Framework {
    DataBaseManager dbManager;

    public Framework(DataBaseManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * if news in db, then ignore it, if not, add the current date, and then add
     * to the db.
     *
     * @param news the news class to be added.
     */
    public void updateRecord(News news) {
        if (!dbManager.contains(news)) {
            // create new record with date added.
            NewsRecord record = new NewsRecord(LocalDate.now(), news);
            // send http request to db to add the record
            dbManager.addRecord(record);
        }
    }
}
