package org.lucidant.general;

import java.math.BigDecimal;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Demonstrates checking for logging statements with logback and Mockito
 * <p>
 * <a href="https://onedrive.live.com/view.aspx?resid=7CB52826C960960B%21131&id=documents&wd=target%28Testing.one%7C34F2DD63-5862-44F8-9E3A-DD4F27CDD9A3%2FTesting%20Logging%7C7F78CAE9-4110-4A2F-94D3-9B54A2CBDD20%2F%29">One Note Detail</a>s
 */
class LoggingCheckTest {

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);

        final Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.addAppender(mockAppender);
        root.setLevel(Level.INFO);
    }


    @DisplayName("Checking for an INFO level log statement")
    @Test
    void givenInputWithThreeDecimal_whenSum_thenRoundToTwo() {
        var bd1 = new BigDecimal("3.501");
        var bd2 = new BigDecimal("2.99");

        var moneyCalculator = new BigDecimalRound(bd1, bd2);

        assertThat(moneyCalculator.sum()).isEqualTo("6.49");
        checkLogsForMessage("[INFO] Adding 3.50 to 2.99", Level.INFO);
    }

    private void checkLogsForMessage(String expected, Level level) {
        verify(mockAppender, atLeastOnce()).doAppend(captorLoggingEvent.capture());
        final var eventsAppender = new LoggingEventsAppender(captorLoggingEvent.getAllValues());
        assertTrue(eventsAppender.containsMessage(expected, level));
    }
}
