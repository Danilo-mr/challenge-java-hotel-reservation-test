public class ExecuteProgram {
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        String cheapestHotel = hotelReservation.getCheapestHotel("Rewards: 10May2022(mon), 11May2022(tues), 12May2022(wed)");
        System.out.println(cheapestHotel);
    }
}
