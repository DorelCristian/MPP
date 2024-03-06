import model.ComputerRepairRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    @Test
    @DisplayName("First Test")
    public void test1(){
        ComputerRepairRequest request = new ComputerRepairRequest(1,"A A","Address A","072222","Asus","13/10/2020","Broken display");
        assertEquals(1,request.getID());
        assertEquals("A A",request.getOwnerName());
        assertEquals("Address A",request.getOwnerAddress());
        assertEquals("072222",request.getPhoneNumber());
        assertEquals("Asus",request.getModel());
        assertEquals("13/10/2020",request.getDate());
        assertEquals("Broken display",request.getProblemDescription());
    }

    @Test
    @DisplayName("Second Test")
    public void test2(){
        ComputerRepairRequest request = new ComputerRepairRequest(2,"B B","Address B","072222","Acer","10/10/2020","Faulty keyboard");
        assertEquals(2,request.getID());
        assertEquals("B B",request.getOwnerName());
        assertEquals("Address B",request.getOwnerAddress());
        assertEquals("072222",request.getPhoneNumber());
        assertEquals("Acer",request.getModel());
        assertEquals("10/10/2020",request.getDate());
        assertEquals("Faulty keyboard",request.getProblemDescription());
    }

    @Test
    @DisplayName("Third Test")
    public void test3()
    {
        assertEquals(2,2,"2 is not equal to 2");
    }

      
}
