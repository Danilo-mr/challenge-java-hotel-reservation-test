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

        String guestType = (input.substring(0, input.indexOf(":"))).toUpperCase();
        if(guestType.equals("REGULAR")) {
            this.guestType = GuestType.REGULAR;
        } else if (guestType.equals("REWARDS")) {
            this.guestType = GuestType.REWARDS;
        } else {
            System.err.println("Input is not valid!");
            System.exit(1);
        }

        String cheapestHotel = compareHotelsReservationsPrices();
        return cheapestHotel;
    }

    public String compareHotelsReservationsPrices() {
        Hotel lakewood = new Hotel("Lakewood", 110, 80,
                90, 80, 3);
        int lakewoodReservationPrice = lakewood.calculateReservationPrice(daysOfTheWeekReservation, guestType);

        Hotel bridgewood = new Hotel("Bridgewood", 160, 110,
                60, 50, 4);
        int bridgewoodReservationPrice = bridgewood.calculateReservationPrice(daysOfTheWeekReservation, guestType);

        Hotel ridgewood = new Hotel("Ridgewood", 220,100,
                150, 40, 5);
        int ridgewoodReservationPrice = ridgewood.calculateReservationPrice(daysOfTheWeekReservation, guestType);
        if(lakewoodReservationPrice != bridgewoodReservationPrice) {
            if(lakewoodReservationPrice != ridgewoodReservationPrice) {
                if (bridgewoodReservationPrice != ridgewoodReservationPrice) {
                    if (lakewoodReservationPrice < bridgewoodReservationPrice && lakewoodReservationPrice < ridgewoodReservationPrice) {
                        return "Lakewood";
                    } else if (bridgewoodReservationPrice < lakewoodReservationPrice && bridgewoodReservationPrice < ridgewoodReservationPrice) {
                        return "Bridgewood";
                    } else {
                        return "Ridgewood";
                    }
                } else if(bridgewoodReservationPrice < lakewoodReservationPrice) {
                    if (bridgewood.getClassification() > ridgewood.getClassification()) {
                        return "Bridgewood";
                    } else {
                        return "Ridgewood";
                    }
                } else {
                    return "Lakewood";
                }
            } else if(lakewoodReservationPrice < bridgewoodReservationPrice) {
                if (lakewood.getClassification() > ridgewood.getClassification()) {
                    return "Lakewood";
                } else {
                    return "Ridgewood";
                }
            } else {
                return "Bridgewood";
            }
        } else if(lakewoodReservationPrice < ridgewoodReservationPrice) {
            if (lakewood.getClassification() > bridgewood.getClassification()) {
                return "Lakewood";
            } else {
                return "Bridgewood";
            }
        } else {
            return "Ridgewood";
        }
    }

}
