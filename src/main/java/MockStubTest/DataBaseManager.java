package MockStubTest;

/**
 * the manager class that connect to database and sent request to
 * check or update the data record.
 * @author Yuzhe Guo
 */
public class DataBaseManager {
    String ip;
    int port;

    public DataBaseManager(String ip, int port) {
        this.ip = ip;
        this.port = port;
        // make database connection, pretend it works
    }

    public boolean contains(News news) {
        // send request to database to check if contains news
        // pretend it works
        return true;
    }

    public void addRecord(NewsRecord news) {
        // add news record to database by sending request.
        // pretend it works
    }
}
