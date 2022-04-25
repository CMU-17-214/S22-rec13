package MockStubTest;

import java.time.LocalDate;

/**
 * the news record that stored in the database.
 */
public record NewsRecord(LocalDate dateAdded, News news) {
}
