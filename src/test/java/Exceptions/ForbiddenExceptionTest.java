package Exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForbiddenExceptionTest {
    @Test
    public void getCode() throws Exception {
        ForbiddenException forbiddenException = new ForbiddenException();
        int result = forbiddenException.getCode();
        assertTrue(result==403);
    }

    @Test
    public void getMessage() throws Exception {
        ForbiddenException forbiddenException = new ForbiddenException();
        String result = forbiddenException.getMessage();
        assertNotNull(result);
    }

}