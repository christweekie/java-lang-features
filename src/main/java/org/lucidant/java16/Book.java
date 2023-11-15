package org.lucidant.java16;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Records are immutable. All fields final. etc.
 *
 * @param title
 * @param publicationYear
 * @param author
 * @param isbn
 */
public record Book(String title, Integer publicationYear, String author, Long isbn) {

    /**
     * Can still have constructors
     * @param title
     *   the title
     * @param publicationYear
     *   the year
     * @param author
     *   the author
     */
    Book(String title, Integer publicationYear, String author) {
        this(title, publicationYear, author, null);
    }

    private static final String ISBN_FORMAT = "^\\d{13}$";

    public String formatAuthor() {
        return author.toUpperCase(Locale.ROOT);
    }

    public boolean isValidIsbn() {
        return Pattern.compile(ISBN_FORMAT).matcher(isbn.toString()).matches();
    }
}
