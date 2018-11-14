package org.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PersonTest {

    private Person person;

    @Before
    public void beforeMethod(){
        person = new Person("Larry", 30, "medic", "123456789", "white");
    }

    @Test
    public void canConstructAPersonWithAName() {
        
        assertEquals("Larry", person.getName());
    }

    @Test
    public void canConstructAPersonNegativeWithAName() {
        
        assertNotEquals("Lar", person.getName());
    }

    @Test
    public void testOne(){
        assertNotEquals("Barry", person.getName());
    }

    @Test
    public void testTwo(){
        assertNotEquals("withe", person.getLasName());
    }

    @Test
    public void testThree(){
        assertEquals("white", person.getLasName());
    }

    @Test
    public void testFour(){
        assertEquals(30, person.getAge());
    }

    @Test
    public void testFive(){
        assertNotEquals(31, person.getAge());
    }

    @Test
    public void testSix(){
        assertEquals("medic", person.getJob());
    }

    @Test
    public void testSeven(){
        assertNotEquals("hola mundo", person.getJob());
    }

    @Test
    public void testEight(){
        assertNotEquals("hola", person.getId());
    }

    @Test
    public void testNine(){
        assertEquals("123456789", person.getId());
    }
}
