import org.junit.Test;
import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void test1() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
   }
   @Test
   public void test2() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Bridgewood", Hotel.getCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
   }
   @Test
   public void test3() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
   }
   @Test
   public void test4() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 07May2022(sat)"));
   }
    @Test
    public void test5() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 05May2022(thur), 06May2022(fri), 07May2022(sat), 08May2022(sun)"));
    }
    @Test
    public void test6() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Lakewood", Hotel.getCheapestHotel("Rewards: 06Jun2022(mon), 07Jun2022(tues), 08Jun2022(wed), 09Jun2022(thur)"));
    }
    @Test
    public void test7() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Bridgewood", Hotel.getCheapestHotel("Regular: 21May2022(sat), 22May2022(sun), 23May2022(mon)"));
    }
}
