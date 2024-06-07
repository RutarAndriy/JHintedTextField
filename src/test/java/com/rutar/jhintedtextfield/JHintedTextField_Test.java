package com.rutar.jhintedtextfield;

import java.io.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// ............................................................................

/**
 * Клас JHintedTextField_Test
 * @author Rutar_Andriy
 * 06.06.2024
 */

@DisplayName("Main test class")
public class JHintedTextField_Test {

private static final String RESOURCES_PATH =
    "src/test/resources/com/rutar/jhintedtextfield/";

///////////////////////////////////////////////////////////////////////////////

@Test
@DisplayName("Should pass")
void should_Answer_With_True()
    { assertTrue(true); }

///////////////////////////////////////////////////////////////////////////////

@Test
@DisplayName("File .empty exist")
void file_Empty_Exist()
    { File file = new File(RESOURCES_PATH + ".empty");
      assertTrue(file.exists()); }

///////////////////////////////////////////////////////////////////////////////
    
// @Test
// @Disabled("skipped")
// @DisplayName("Should skip")
// void should_Skip() {
//     fail("This error will be skipped");
// }

///////////////////////////////////////////////////////////////////////////////

// @Test
// @DisplayName("Should fail")
// void should_Fail() {
//     fail("Some error ...");
// }

// Кінець класу JHintedTextField_Test /////////////////////////////////////////

}
