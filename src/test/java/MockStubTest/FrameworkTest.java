package MockStubTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * the class for testing the framework class and show demo of mock/stub testing.
 *
 * @author Yuzhe Guo
 */
public class FrameworkTest {

    Framework framework;
    DataBaseManager dbManager;
    News sampleNews;
    NewsRecord sampleNewsRecord;

    @Before
    public void setUp() throws Exception {
        // mock the DataBaseManager class
        dbManager = mock(DataBaseManager.class);
        framework = new Framework(dbManager);
        // create sample data
        sampleNews = new News(LocalDateTime.of(2020, 1, 1, 10, 10), "sample news", true);
        // create sample expected data to be added to db
        sampleNewsRecord = new NewsRecord(LocalDate.now(), sampleNews);
    }

    /**
     * normal test for updateRecord method.
     * How to test method that has void return?
     */
    @Test
    public void testUpdateRecordNoMock() {
        framework.updateRecord(sampleNews);
        // why it is difficult to test this method without mock test?
    }

    /**
     * test that if news in db, then the addRecord method
     * is never called. using verify()
     */
    @Test
    public void testUpdateRecordContainsNotMethodCall() {
        // stub the dbManager contains to return true
        // TODO: use when().thenReturn() to set the stub

        // try call the method
        framework.updateRecord(sampleNews);
        // verify the addRecord is never called
        verify(dbManager, times(0)).addRecord(isA(NewsRecord.class));
    }

    /**
     * test if news not in db, then addRecord is called once
     */
    @Test
    public void testUpdateRecordNotContainsMethodCall() {
        // stub the dbManager contains to return false
        // TODO: use when().thenReturn() to set the stub

        // try call the method
        framework.updateRecord(sampleNews);
        // verify the addRecord is called once
        verify(dbManager, times(1)).addRecord(isA(NewsRecord.class));
    }

    /**
     * test that if news not in db, then the data that been sent
     * has not null timeStamp and the news is not changed.
     */
    @Test
    public void testUpdateRecordCheckData() {
        // stub the dbManager contains to return false
        when(dbManager.contains(sampleNews)).thenReturn(false);
        // try call the method
        framework.updateRecord(sampleNews);

        // create class myCaptor to capture the argument.
        ArgumentCaptor<NewsRecord> myCaptor = ArgumentCaptor.forClass(NewsRecord.class);

        // capture the argument
        verify(dbManager).addRecord(myCaptor.capture());

        // get the NewsRecord that has been captured.
        NewsRecord captured = myCaptor.getValue();

        // check
        assertEquals(sampleNewsRecord, captured);
    }
}