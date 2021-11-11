package com.chucknorris.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChuckNorrisTest {
    @Test
    public void testGetFact(){
        ChuckNorris ck = new ChuckNorris();
        String fact = ck.getFact();
        assertTrue(fact.contains("Chuck Norris"));
    }
}
