package org.lucidant.java16;

import java.util.Locale;

public record Book(String title, Integer publicationYear, String author) {

    public String formatAuthor() {
        return author.toUpperCase(Locale.ROOT);
    }

}
