package org.lucidant.general;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class LoggingEventsAppender extends ListAppender<ILoggingEvent> {

    public LoggingEventsAppender(List<LoggingEvent> allValues) {
        super();
        this.list.addAll(allValues);
    }

    public boolean containsMessage(String string, Level level) {
        return testCondition(event -> event.toString().contains(string) && event.getLevel().equals(level));
    }

    private boolean testCondition(Predicate<ILoggingEvent> condition) {
        final var event = Optional.ofNullable(this.list)
            .orElse(Collections.emptyList())
            .stream()
            .filter(condition)
            .findAny();

        return event.isPresent();
    }

}
