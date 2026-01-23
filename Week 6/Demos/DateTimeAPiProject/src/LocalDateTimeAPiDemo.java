import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAPiDemo {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(" The Current Date is " + date);

		LocalTime time = LocalTime.now();
		System.out.println(" The Current Time is " + time);

		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("current date and time : " + current);

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		String formattedDateTime = current.format(format);
		System.out.println("Formatted Date" + formattedDateTime);

		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		System.out.println("Month : " + month + " day : " + day + " seconds : " + seconds);

		LocalDate date2 = LocalDate.of(1950, 1, 26);
		System.out.println("the republic day :" + date2);
		// printing date with current time.
		LocalDateTime specificDate = current.withDayOfMonth(14).withYear(202+8);

		System.out.println("specific date with " + "current time : " + specificDate);
	}
}
