import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class ZonedAPIDemo {

	public static void ZoneDetails() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formattedCurrentDate = date.format(format1);

		System.out.println("formatted current Date and" + " Time : " + formattedCurrentDate);

		// to get the current zone
		ZonedDateTime currentZone = ZonedDateTime.now();
		System.out.println("the current zone is ");

		ZoneId calcutta = ZoneId.of("Asia/Calcutta");

		ZonedDateTime calcuttaZone = currentZone.withZoneSameInstant(calcutta);

		System.out.println("Calcutta time zone is " + calcuttaZone);
	}

	
	public static void checkingPeriod() {
		LocalDate date1=LocalDate.now();		
		LocalDate date2= LocalDate.of(2020, Month.OCTOBER,10);
		Period   gap=Period.between(date1, date2);
		System.out.println( "Gap between "+date1 +"and  "+date2 +"is  = " +gap);
	//	System.out.println(STR."gap between dates is a period of \{gap}");;
	}
	
	
    public static void checkingDuration()
    {

        LocalTime time1 = LocalTime.now();
        System.out.println("the current time is " + time1);

        Duration fiveHours = Duration.ofHours(5);

        // adding five hours to the current time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);

        System.out.println("after adding five hours " + "of duration " + time2);

        Duration gap = Duration.between(time2, time1);
        System.out.println("duration gap between time1" + " & time2 is " + gap);
    }
    
 // Function to check ChronoUnit
    public static void checkingChronoEnum()
    {
        LocalDate date = LocalDate.now();
        System.out.println("current date is :" + date);

        // adding 2 years to the current date
        LocalDate year = date.plus(2, ChronoUnit.YEARS);

        System.out.println("next to next year is " + year);

        // adding 1 month to the current date
        LocalDate nextMonth = date.plus(1, ChronoUnit.MONTHS);

        System.out.println("the next month is "
                           + nextMonth);

        // adding 1 week to the current date
        LocalDate nextWeek = date.plus(1, ChronoUnit.WEEKS);

        System.out.println("next week is " + nextWeek);

        // adding 2 decades to the current date
        LocalDate Decade = date.plus(2, ChronoUnit.DECADES);

        System.out.println("20 years after today " + Decade);
    }

    // Function to check date and time according to our requirement
    public static void checkingAdjusters()
    {

        LocalDate date = LocalDate.now();
        System.out.println("the current date is " + date);

        // to get the first day of next month
        LocalDate dayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());

        System.out.println("firstDayOfNextMonth : "+ dayOfNextMonth);

        // get the next saturday
        LocalDate nextSaturday = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

        System.out.println("next saturday from now is "+ nextSaturday);

        // first day of current month
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("firstDayOfMonth : " + firstDay);

        // last day of current month
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("lastDayOfMonth : " + lastDay);
    }


	public static void main(String[] args) {
		// ZoneDetails();		
		//checkingPeriod();
		//checkingDuration();		
		//checkingChronoEnum();
		checkingAdjusters();
		 
	}
}
