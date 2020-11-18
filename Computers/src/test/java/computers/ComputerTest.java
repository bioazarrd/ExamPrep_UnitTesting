package computers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ComputerTest {


    private Computer computer;

//before = predvartileno zadaven na stoinost kym pole v testoviq klas
    // predi vseki edin test, setUp-a shte se izvika zashtoto e anotiran s before
    //i shte kaje che poleto computer e ravno na new Computer s ime xxxx
    @Before
    public void setUp() {
        this.computer = new Computer( "Test_Name");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructorForNullName() {
        new Computer(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructorForEmptyName() {
        new Computer( "");
    }


    @Test
    public void testConstructorForCorrectName() {
        Computer computer = new Computer( "Test_Name");
        assertEquals("Test_Name", computer.getName());
    }


    @Test
    public void testGetPartsShouldReturnCollection() {
        assertNotNull(this.computer.getParts());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsShouldReturnUnmodifiableCollection() {
        this.computer.getParts().add(new Part("test", 13));
    }


    @Test
    public void testGetTotalPriceShouldReturnZeroWhenEmpty() {
        double totalPrice = this.computer.getTotalPrice();
        //nedei zabravq delta-ta kogato imash floating point chisla
        assertEquals(0.00, totalPrice, 0.00);
    }


    @Test
    public void testGetTotalPriceShouldReturnZeroWhenNotEmpty() {
        this.computer.addPart(new Part("Part", 13));
        this.computer.addPart(new Part("Part", 13));
        double totalPrice = this.computer.getTotalPrice();
        //nedei zabravq delta-ta kogato imash floating point chisla
        assertEquals(0.00, totalPrice, 26.00);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddPartShouldThrow() {
        this.computer.addPart(null);
    }


    @Test
    public void testAddPartShouldAddThePart() {
        this.computer.addPart(new Part("Part", 13));
        assertNotNull(this.computer.getPart("Part"));
    }


    @Test
    public void testRemovePart() {
        Part part = new Part("Part", 13);
        assertFalse(this.computer.removePart(part));
        this.computer.addPart(part);
        assertTrue(this.computer.removePart(part));
    }


    @Test
    public void testGetPartShouldReturnNull() {
        assertNull(this.computer.getPart("Part"));
    }



    @Test
    public void testGetPartShouldReturnSamePart() {
        Part part = new Part("Part", 13);
        this.computer.addPart(part);
        assertNotNull(this.computer.getPart("Part"));
    }



}