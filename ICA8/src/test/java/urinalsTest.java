import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @Test
    void goodString() {

        System.out.println("====== Ajay Babu Yadavalli == TEST TWO EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 10101");
        assertEquals(true,urinals.goodString("10101"));

        System.out.println("====== Ajay Babu Yadavalli == TEST THREE EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 1001");
        assertEquals(true,urinals.goodString("1001"));

        System.out.println("====== Ajay Babu Yadavalli == TEST FOUR EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 00000");
        assertEquals(true,urinals.goodString("00000"));

        System.out.println("====== Ajay Babu Yadavalli == TEST FIVE EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 0000");
        assertEquals(true,urinals.goodString("0000"));

        System.out.println("====== Ajay Babu Yadavalli == TEST SIX EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 01000");
        assertEquals(true,urinals.goodString("01000"));

        System.out.println("====== Ajay Babu Yadavalli == TEST SEVEN EXECUTED =======");
        System.out.println("Executed properly and passed assertion with 011");
        assertEquals(false,urinals.goodString("011"));

    }

    @Test
    public void countUrinals() {
        System.out.println("======Ajay Babu Yadavalli == TEST EIGHT EXECUTED =======");
        assertEquals(1,urinals.countUrinals("01000"));

        System.out.println("======Ajay Babu Yadavalli == TEST NINE EXECUTED =======");
        assertEquals(0,urinals.countUrinals("1001"));
    }

}