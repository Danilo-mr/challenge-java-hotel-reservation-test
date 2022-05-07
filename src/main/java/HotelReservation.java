import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservation {
    private List<Integer> daysOfTheWeekReservation;
    private GuestType guestType;

    public String getCheapestHotel (String input) {
        String regex = "[0-9]{2}[A-z]{3,4}[0-9]{4}\\(([a-z]{3,4})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String guestType = (input.substring(0, input.indexOf(":"))).toUpperCase();
        if(guestType.equals("REGULAR")) {
            this.guestType = GuestType.REGULAR;
        } else if (guestType.equals("REWARDS")) {
            this.guestType = GuestType.REWARDS;
        } else {
            System.err.println("Input is not valid!");
            System.exit(1);
        }

        daysOfTheWeekReservation = new ArrayList<>();
        while(matcher.find()) {
            if(matcher.group(1).equals("sun")) daysOfTheWeekReservation.add(1);
            if(matcher.group(1).equals("mon")) daysOfTheWeekReservation.add(2);
            if(matcher.group(1).equals("tues")) daysOfTheWeekReservation.add(3);
            if(matcher.group(1).equals("wed")) daysOfTheWeekReservation.add(4);
            if(matcher.group(1).equals("thur")) daysOfTheWeekReservation.add(5);
            if(matcher.group(1).equals("fri")) daysOfTheWeekReservation.add(6);
            if(matcher.group(1).equals("sat")) daysOfTheWeekReservation.add(7);
        }


        String cheapestHotel = compareHotelsReservationsPrices();
        return cheapestHotel;
    }

    public String compareHotelsReservationsPrices() {
        ArrayList<Hotel> hotel = new ArrayList<>(3);
        ArrayList<Integer> price = new ArrayList<>(3);

        hotel.add(new Hotel("Lakewood", 110, 80,
                90, 80, 3));
        price.add(hotel.get(0).calculateReservationPrice(daysOfTheWeekReservation, guestType));

        hotel.add(new Hotel("Bridgewood", 160, 110,
                60, 50, 4));
        price.add(hotel.get(1).calculateReservationPrice(daysOfTheWeekReservation, guestType));

        hotel.add(new Hotel("Ridgewood", 220, 100,
                150, 40, 5));
        price.add(hotel.get(2).calculateReservationPrice(daysOfTheWeekReservation, guestType));

        int[] lowerPrice = new int[price.size()];
        int actualLower = price.get(0);
        lowerPrice[0] = actualLower;

        for(int i=1; i< price.size(); i++) {
            if(price.get(i) < actualLower) {
                actualLower = price.get(i);
                for(int j=0; j<i; j++) {
                    lowerPrice[j] = -1;
                }
                lowerPrice[i] = actualLower;
            } else if(actualLower == price.get(i)) {
                lowerPrice[i] = actualLower;
            } else {
                lowerPrice[i] = -1;
            }
        }

        String cheaperHotel = "";
        for(int i=0, lastLowerIndex=-1; i<lowerPrice.length; i++) {
            if(lowerPrice[i]==-1) {
                continue;
            } else {
                if(lastLowerIndex==-1) {
                    cheaperHotel = hotel.get(i).getName();
                    lastLowerIndex = i;
                } else {
                    cheaperHotel = hotel.get(i).getClassification() > hotel.get(lastLowerIndex).getClassification() ? hotel.get(i).getName() : hotel.get(lastLowerIndex).getName();
                }
            }
        }
        return cheaperHotel;
    }

}
