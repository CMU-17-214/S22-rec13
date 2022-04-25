package MockStubTest;

import java.time.LocalDateTime;

/**
 * the news record with time of news, string of content, isFake label.
 */
public record News(LocalDateTime time, String content, Boolean isFake) {
}
