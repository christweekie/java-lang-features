package org.lucidant.java16;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


// Default is surprisingly PER_METHOD which is OK if you are worried about shared state in the class
// But if you are managing that and speed is a worry, do per class
@TestInstance(value = Lifecycle.PER_CLASS)
class BookTest {

    private static final long ISBN = 1234567891234L;

    private static final Book TALE_OF_TWO_CITIES = new Book("Tale of Two Cities", 1865, "Charles Dickens", ISBN);

    @Test
    void testEquality() {

        assertThat(TALE_OF_TWO_CITIES.title()).isEqualTo("Tale of Two Cities");
        assertThat(TALE_OF_TWO_CITIES.publicationYear()).isEqualTo(1865);
        assertThat(TALE_OF_TWO_CITIES.author()).isEqualTo("Charles Dickens");
        assertThat(TALE_OF_TWO_CITIES.isbn().longValue()).isEqualTo(ISBN);
    }

    @Test
    void testToString() {
        assertThat(TALE_OF_TWO_CITIES.toString())
                .isEqualTo("Book[title=Tale of Two Cities, publicationYear=1865, author=Charles Dickens, isbn=1234567891234]");
    }

    @Test
    void testConstructor() {
        assertThat(new Book("Life After Life", 2009, "Kate Atkinson").toString())
                .isEqualTo("Book[title=Life After Life, publicationYear=2009, author=Kate Atkinson, isbn=null]");
    }

    @Test
    void testInstanceOfImprovements() {
        var o = getIt();
        if (o instanceof Book book) {
            assertThat(book.formatAuthor()).isEqualTo("CHARLES DICKENS");
        }
    }

    @Test
    void isValidIsbn() {
        assertThat(TALE_OF_TWO_CITIES.isValidIsbn()).isTrue();
    }

    @Test
    void simpleEqualsContract() {
        EqualsVerifier.simple().forClass(Book.class).verify();
    }

    @Test
    void newToListInsteadOfCollectors() {
        var integersAsString = Arrays.asList("1", "2", "3");
        var ints = integersAsString.stream().map(Integer::parseInt).collect(Collectors.toList());
        var intsEquivalent = integersAsString.stream().map(Integer::parseInt).toList();

        RecursiveComparisonConfiguration configuration = RecursiveComparisonConfiguration.builder()
                .build();

        assertThat(intsEquivalent).isEqualTo(ints);
    }


    private Object getIt() {
        return TALE_OF_TWO_CITIES;
    }
}
