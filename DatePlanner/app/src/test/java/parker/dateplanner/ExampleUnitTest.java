package parker.dateplanner;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}

public class GPSTest {
    @Test
    public void gps_null() throws Exception{
        String test = null;
        assertNull(GPS.locate(test));
    }
}
