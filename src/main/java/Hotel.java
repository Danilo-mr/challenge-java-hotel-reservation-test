import java.util.List;

public class Hotel {
    private String name;
    private int weekdaysDailyRatesForRegulars;
    private int weekdaysDailyRatesForRewards;
    private int weekendDailyRatesForRegulars;
    private int weekendDailyRatesForRewards;
    private int classification;

    public Hotel(String name, int weekdaysDailyRatesForRegulars, int weekdaysDailyRatesForRewards, int weekendDailyRatesForRegulars, int weekendDailyRatesForRewards, int classification) {
        this.name = name;
        this.weekdaysDailyRatesForRegulars = weekdaysDailyRatesForRegulars;
        this.weekdaysDailyRatesForRewards = weekdaysDailyRatesForRewards;
        this.weekendDailyRatesForRegulars = weekendDailyRatesForRegulars;
        this.weekendDailyRatesForRewards = weekendDailyRatesForRewards;
        this.classification = classification;
    }

    public int calculateReservationPrice(List<Integer> daysOfTheWeekReservation, GuestType guestType) {
        int price=0;
        if(guestType.equals(GuestType.REGULAR)) {
            for (int dayOfTheWeek : daysOfTheWeekReservation) {
                if(dayOfTheWeek >= 2 && dayOfTheWeek <= 6) {
                    price+=this.weekdaysDailyRatesForRegulars;
                } else {
                    price+=this.weekendDailyRatesForRegulars;
                }
            }
        }
        if(guestType.equals(GuestType.REWARDS)) {
            for(int dayOfTheWeek : daysOfTheWeekReservation) {
                if(dayOfTheWeek >=2 && dayOfTheWeek <=6) {
                    price+=this.weekdaysDailyRatesForRewards;
                } else {
                    price+=this.weekendDailyRatesForRewards;
                }
            }
        }
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekdaysDailyRatesForRegulars() {
        return weekdaysDailyRatesForRegulars;
    }

    public void setWeekdaysDailyRatesForRegulars(int weekdaysDailyRatesForRegulars) {
        this.weekdaysDailyRatesForRegulars = weekdaysDailyRatesForRegulars;
    }

    public int getWeekdaysDailyRatesForRewards() {
        return weekdaysDailyRatesForRewards;
    }

    public void setWeekdaysDailyRatesForRewards(int weekdaysDailyRatesForRewards) {
        this.weekdaysDailyRatesForRewards = weekdaysDailyRatesForRewards;
    }

    public int getWeekendDailyRatesForRegulars() {
        return weekendDailyRatesForRegulars;
    }

    public void setWeekendDailyRatesForRegulars(int weekendDailyRatesForRegulars) {
        this.weekendDailyRatesForRegulars = weekendDailyRatesForRegulars;
    }

    public int getWeekendDailyRatesForRewards() {
        return weekendDailyRatesForRewards;
    }

    public void setWeekendDailyRatesForRewards(int weekendDailyRatesForRewards) {
        this.weekendDailyRatesForRewards = weekendDailyRatesForRewards;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }
}
