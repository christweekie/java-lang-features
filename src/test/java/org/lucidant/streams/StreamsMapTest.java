package org.lucidant.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.lucidant.general.Money;
import org.lucidant.general.Name;

import static org.assertj.core.api.Assertions.assertThat;

class StreamsMapTest<I> {

    /**
     * mapToObj is same as map, except it works on primitives, "int" here
     */
    @Test
    void testMapObj() {

        // This is our list of data to paginate, 2 items per page
        final List<Character> collection = List.of('a', 'z', 'd', 'r', 'f', 'u', 'e');
        final int itemsPerPage = 2;

        // We create a list entry just when we need a new page
        // Count through whole collection
        // If count is at item size (modulus, no counter reset)
        // Extract from list from counter, say 2, to 2 plus items per page (4)
        //
        final List<List<Character>> list = IntStream.range(0, collection.size())
            .filter(i -> i % itemsPerPage == 0)
            .mapToObj(i -> collection.subList(i, Math.min(i + itemsPerPage, collection.size())))
            .toList();

        assertThat(list).hasSize(4);
        assertThat(list.getFirst()).hasSize(2);
        assertThat(list.getLast()).hasSize(1);
    }

    @Test
    void whenFlatMap() {
        var name1 = Name.builder().forename1("Chris")
            .middleNames(List.of("James", "Brown"))
            .surname("Faulkner").build();
        var name2 = Name.builder().forename1("Liz")
            .middleNames(List.of("Brown", "Elizabeth"))
            .surname("Windsor").build();

        var names = List.of(name1, name2);

        var allMiddleNames = names.stream()
                .flatMap(name -> name.getMiddleNames().stream())
                .distinct()
                .collect(Collectors.toList());

        assertThat(allMiddleNames).hasSize(3);
    }

}
