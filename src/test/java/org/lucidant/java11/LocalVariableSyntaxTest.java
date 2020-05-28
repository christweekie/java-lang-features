package org.lucidant.java11;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocalVariableSyntaxTest {


    @Test
    @DisplayName("Type inference pre Java 11")
    void getLambdaVarPre11() {
        // Implicitly typed params
        FilenameFilter xmlFiles = (dir, filename) -> filename.endsWith(".xml") && "target".equals(dir.getName());

        assertThat(xmlFiles.accept(new File("./target"), "logback.xml")).isTrue();
    }


    @Test
    @DisplayName("Type inference post Java 11. Good because you can use NoNull and annotations")
    void getLambdaVarFrom11() {
        FilenameFilter xmlFiles = (@NotNull var dir, @NotNull var filename)
            -> filename.endsWith(".xml") && "target".equals(dir.getName());

        assertThat(xmlFiles.accept(new File("./target"), "logback.xml")).isTrue();
    }
}
