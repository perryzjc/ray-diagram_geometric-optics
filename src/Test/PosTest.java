package Test;

import Main.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosTest {
    @Test
    public void testRelativePos() {
        Pos p = new Pos(1, 2);
        assertEquals(1, p.x(), 0.0001);
        assertEquals(2, p.y(), 0.0001);
    }

    @Test
    public void testAbsolutePos() {
        Pos p = new Pos(1, 2);
        assertEquals(401, p.drawX(), 0.0001);
        assertEquals(302, p.drawY(), 0.0001);
    }

    @Test
    public void testOffY() {
        Pos p1 = new Pos(1, 2);
        Pos p2 = new Pos(3, 4);
        assertEquals(2, Pos.offY(p1, p2), 0.0001);
    }

    @Test
    public void testAddRelativePos() {
        Pos p1 = new Pos(1, 2);
        Pos p2 = new Pos(3, 4);
        Pos p3 = p1.add(p2);
        assertEquals(4, p3.x(), 0.0001);
        assertEquals(6, p3.y(), 0.0001);
    }
}