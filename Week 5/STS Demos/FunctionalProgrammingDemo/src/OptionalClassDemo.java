import java.util.Optional;

public class OptionalClassDemo {

	public static void main(String[] args) {
		
		
		// value is present
		String email="test@mail.com";
		
		//value is missing (null)
		String phone=null;
		
		Optional<String> optEmail=Optional.ofNullable(email);
		Optional<String> optPhone=Optional.ofNullable(phone);
//		
//		//1) isPresent
//		System.out.println("1. isPresent ()  + get ()");
//		if(optEmail.isPresent())
//		{
//			System.out.println("Email Exists : "+optEmail.get());
//		}
//		if(optPhone.isPresent())
//		{
//			System.out.println("Phone Exists : "+optPhone.get());
//		}
//		else
//		{
//			System.out.println("Phone does not exist, so get() will not be called");
//		}
//		 System.out.println("----------------------------------");
//		// -------------------------------
//	        // 2) ifPresent()
//	        // -------------------------------
//	        System.out.println("2) ifPresent()");
//	        optEmail.ifPresent(e -> System.out.println("Email is: " + e));
//	        optPhone.ifPresent(p -> System.out.println("Phone is: " + p)); // nothing prints
//
//	        System.out.println("----------------------------------");
//	        
//	        // -------------------------------
//	        // 3) ifPresentOrElse() (Java 9+)
//	        // -------------------------------
//	        System.out.println("3) ifPresentOrElse()");
//	        optEmail.ifPresentOrElse(
//	                e -> System.out.println("Email Found: " + e),
//	                () -> System.out.println("Email Not Found")
//	        );
//
//	        optPhone.ifPresentOrElse(
//	                p -> System.out.println("Phone Found: " + p),
//	                () -> System.out.println("Phone Not Found")
//	        );
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 4) orElse(defaultValue)
//	        // -------------------------------
//	        System.out.println("4) orElse()");
//	        String emailResult = optEmail.orElse("no-email@mail.com");
//	        String phoneResult = optPhone.orElse("000-000-0000");
//	        System.out.println("Email result: " + emailResult);
//	        System.out.println("Phone result: " + phoneResult);
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 5) orElseGet(Supplier)  (lazy)
//	        // -------------------------------
//	        System.out.println("5) orElseGet()");
//	        String phoneResult2 = optPhone.orElseGet(() -> {
//	            System.out.println("Generating default phone...");
//	            return "999-999-9999";
//	        });
//	        System.out.println("Phone result2: " + phoneResult2);
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 6) orElseThrow()
//	        // -------------------------------
//	        System.out.println("6) orElseThrow()");
//	        String emailMustExist = optEmail.orElseThrow(); // no exception (email present)
//	        System.out.println("Email must exist: " + emailMustExist);
//
//	        // Uncomment to see exception when phone is null
//	        // String phoneMustExist = optPhone.orElseThrow();  // throws NoSuchElementException
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 7) orElseThrow(custom exception)
//	        // -------------------------------
//	        System.out.println("7) orElseThrow(custom exception)");
//	        // Uncomment to see custom exception
//	        // String phoneRequired = optPhone.orElseThrow(() -> new IllegalArgumentException("Phone is required!"));
//
//	        System.out.println("Custom exception demo is commented to avoid crash.");
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 8) filter()
//	        // -------------------------------
	        System.out.println("8) filter()");
	        Optional<String> gmailOnly = optEmail.filter(e -> e.endsWith("@gmail.com"));
	        System.out.println("Is Gmail? " + gmailOnly.isPresent()); // false for test@mail.com

	        Optional<String> mailOnly = optEmail.filter(e -> e.endsWith("@mail.com"));
	        System.out.println("Is mail.com? " + mailOnly.isPresent()); // true
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 9) map() (transform value)
//	        // -------------------------------
//	        System.out.println("9) map()");
//	        Optional<Integer> emailLength = optEmail.map(e -> e.length());
//	        System.out.println("Email length (Optional): " + emailLength);
//	        System.out.println("Email length (value): " + emailLength.orElse(0));
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 10) flatMap() (Optional inside Optional)
//	        // -------------------------------
//	        System.out.println("10) flatMap()");
//	        Optional<String> domain = optEmail.flatMap(OptionalClassDemo::extractDomain);
//	        System.out.println("Domain: " + domain.orElse("No domain"));
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 11) empty()
//	        // -------------------------------
//	        System.out.println("11) empty()");
//	        Optional<String> emptyOpt = Optional.empty();
//	        System.out.println("emptyOpt isPresent: " + emptyOpt.isPresent());
//
//	        System.out.println("----------------------------------");
//
//	        // -------------------------------
//	        // 12) of() (value must NOT be null)
//	        // -------------------------------
//	        System.out.println("12) of()");
//	        Optional<String> nonNullEmail = Optional.of(email); // email is not null, so OK
//	        System.out.println("Optional.of(email): " + nonNullEmail.get());
//
//	        // Uncomment to see error:
//	        // Optional<String> error = Optional.of(phone); // phone is null -> NullPointerException
//	    }
//
//	    // Helper method for flatMap()
//	    static Optional<String> extractDomain(String email) {
//	        if (email.contains("@")) {
//	            return Optional.of(email.substring(email.indexOf("@") + 1));
//	        }
//	        return Optional.empty();
//	    }
	}
}
	







		


