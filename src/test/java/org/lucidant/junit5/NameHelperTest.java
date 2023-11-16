package org.lucidant.junit5;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.lucidant.general.NameHelper;

import static org.assertj.core.api.Assertions.assertThat;

class NameHelperTest {

    private NameHelper nameHelper;

    @BeforeEach
    void beforeEach() {
        nameHelper = new NameHelper(List.of("MR", "MASTER", "MRS"));
    }

    // Needs junit-jupiter-params dependency
    @ParameterizedTest
    @CsvSource({"Mr ARTHUR MORGAN,ARTHUR MORGAN",
        "Dame Edna EVERAGE,EVERAGE",
        "MasTER William BROWN,BROWN",
        "Mrs JUDI DENCH,JUDI DENCH"})
    void givenVariousTitles_whenGetSurname_thenReturn(String fullName, String expectedSurname) {

        var name = nameHelper.getNameFromFields(fullName);

        assertThat(name.getSurname()).isEqualTo(expectedSurname);
    }
}
