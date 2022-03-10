package org.lucidant.java16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BookTest {

    private static final Book TALE_OF_TWO_CITIES = new Book("Tale of Two Cities", 1865, "Charles Dickens");

    @Test
    void testEquality() {

        assertThat(TALE_OF_TWO_CITIES.title()).isEqualTo("Tale of Two Cities");
        assertThat(TALE_OF_TWO_CITIES.publicationYear()).isEqualTo(1865);
        assertThat(TALE_OF_TWO_CITIES.author()).isEqualTo("Charles Dickens");

        assertThat(TALE_OF_TWO_CITIES)
            .isEqualTo(new Book("Tale of Two Cities", 1865, "Charles Dickens"));

        assertThat(TALE_OF_TWO_CITIES)
            .isNotEqualTo(new Book("Tale of Two Cities", 1865, "charles dickens"));
    }

    @Test
    void testInstanceOfImprovements() {
        var o = getIt();
        if (o instanceof Book book) {
            assertThat(book.formatAuthor()).isEqualTo("CHARLES DICKENS");
        }
    }

    private Object getIt() {
        return TALE_OF_TWO_CITIES;
    }
}
