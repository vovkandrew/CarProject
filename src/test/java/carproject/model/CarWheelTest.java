package carproject.model;

import junit.framework.TestCase;

public class CarWheelTest extends TestCase {
    private CarWheel wheel = new CarWheel(0.8);

    public void testSetNewWheel() {
        double expected = 1;
        wheel.setNewWheel();
        double actual = wheel.getWheelState();
        assertEquals("Testing wheel renewal", expected, actual);
    }

    public void testEraseWheel() {
        double expected = 0.72;
        wheel.eraseWheel(10);
        double actual = wheel.getWheelState();
        assertEquals("Testing wheel erasure", expected, actual);
    }

    public void testReturnCurrentWheelState() {
        String expected = "80%";
        String actual = wheel.returnCurrentWheelState();
        assertEquals("Testing current wheel state return", expected, actual);
    }
}