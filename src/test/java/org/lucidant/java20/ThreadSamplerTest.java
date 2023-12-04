package org.lucidant.java20;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * This is here so I can add ScopedValues when the CircleCI orb allows it.
 * For now, just shows running separate threads from an Executor and ThreadLocal.
 */
@Slf4j
final class ThreadSamplerTest {

    public static final ThreadLocal<Integer> CONTEXT = ThreadLocal.withInitial(() -> 1);

    private final ExecutorService executorService =
            new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>());

    @BeforeAll
    static void beforeAll() {
        log.info("Context value is now {} ", CONTEXT.get());
    }

    @AfterEach
    void afterEach() {
        executorService.shutdown();
    }

    @Test
    void setThreadValue() throws InterruptedException, ExecutionException, TimeoutException {
        final var future1 = executorService.submit(() -> printValue(200));
        final var future2 = executorService.submit(() -> printValue(100));
        assertThat(future1.get(250, TimeUnit.MILLISECONDS)).isTrue();
        assertThat(future2.get(250, TimeUnit.MILLISECONDS)).isTrue();
    }

    @SuppressWarnings("SameReturnValue")
    boolean printValue(final int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CONTEXT.set(delay);
        log.info("Context value is now {} ", CONTEXT.get());
        return true;
    }
}
