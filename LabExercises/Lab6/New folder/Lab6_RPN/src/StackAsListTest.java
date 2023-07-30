import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackAsListTest {

    @Test
    void push() throws StackOverflow, StackUnderflow {
        StackAsList s = new StackAsList();

        // Push Integer
        s.push(123456789);
        assertEquals(123456789, s.top());

        // Push String
        s.push("Hello World!");
        assertEquals("Hello World!", s.top());

        // Push Character
        s.push('C');
        assertEquals('C', s.top());
    }

    @Test
    void pop() throws StackUnderflow, StackOverflow {
        StackAsList s = new StackAsList();

        // Push and Pop
        s.makeEmpty();
        s.push(123);
        s.pop();
        assertTrue(s.isEmpty());

    }

    @Test
    void top() throws StackOverflow, StackUnderflow {
        StackAsList s = new StackAsList();

        s.push("Test");
        assertEquals("Test", s.top());

    }

    @Test
    void isEmpty() throws StackUnderflow, StackOverflow {
        StackAsList s = new StackAsList();

        // Check if empty at beginning
        assertTrue(s.isEmpty());

        // Push and pop and check again
        s.push(123);
        s.pop();
        assertTrue(s.isEmpty());

    }

    @Test
    void makeEmpty() throws StackOverflow {
        StackAsList s = new StackAsList();

        // Fill List
        s.push(1);
        s.push(2);
        s.push(3);

        // List is now expected to not be empty
        assertFalse(s.isEmpty());

        // Remove all objects by using makeEmpty
        s.makeEmpty();

        // List is now expected to be empty
        assertTrue(s.isEmpty());
    }

    @Test
    void testToString() throws StackOverflow {
        StackAsList s = new StackAsList();

        // Fill List
        s.push(1);
        s.push(2);
        s.push(3);

        // Expected output: "TOP: <pushed values separated by comma and space> :BOTTOM"
        assertEquals("TOP: 3, 2, 1 :BOTTOM", s.toString());

    }

    @Test
    void testUnderflow() throws StackUnderflow {
        StackAsList s = new StackAsList();
        assertThrows(StackUnderflow.class, () -> s.pop());
    }

}