package org.lucidant.junit5;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoConstructsTest {

    @Mock
    private List<String> list;

    @Spy
    private List<String> spyList = new ArrayList<>();

    /**
     * A mock doesn't do anything.
     */
    @Test
    void whenMock_thenNoBehaviour() {

        list.add("one");

        // You can't get elements, check size, etc without mocking with "when"
        verify(list).add("one");
    }

    /**
     * A spy is still allowing behaviour, the target class is still real and doing things.
     */
    @Test
    void givenASpy_whenStubbingTheBehaviour_thenCorrect() {

        assertThat(spyList).isEmpty();

        // Can still mock it in the normal way
        doReturn(100).when(spyList).size();
        assertThat(spyList).hasSize(100);

        // But can still use it too to do normal behaviour
        spyList.add("one");
        assertThat(spyList.getFirst()).isEqualTo("one");
    }

    /**
     * Argument captor captures arguments passed to a mock instance
     */
    @Test
    void givenMockedClass_useArgumentCaptor() {
        Calculator calculator = mock(Calculator.class);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        when(calculator.add(anyInt(), anyInt())).thenReturn(5);  // Mocking the add method

        calculator.add(2, 3);

        verify(calculator).add(argumentCaptor.capture(), argumentCaptor.capture());

        // Retrieve the captured arguments
        final var arguments = argumentCaptor.getAllValues();

        // Assert the captured values
        assertThat(arguments.get(0).intValue()).isEqualTo(2);
        assertThat(arguments.get(1).intValue()).isEqualTo(3);
    }

    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }
}
