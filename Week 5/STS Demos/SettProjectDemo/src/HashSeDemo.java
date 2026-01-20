import java.util.*;

public class HashSeDemo {

	public static void main(String[] args) {
		// unique email Regitration
		Set<String> registeredEmails = new HashSet<>();

		System.out.println(registeredEmails.add("arun@gmail.com")); // true
		System.out.println(registeredEmails.add("divya@gmail.com")); // true
		System.out.println(registeredEmails.add("arun@gmail.com")); // false (duplicate)

		System.out.println("Total unique registrations: " + registeredEmails.size());
		System.out.println("Is divya registered? " + registeredEmails.contains("divya@gmail.com"));
		//remove() - Unregister an email
        System.out.println("\nRemove divya: " + registeredEmails.remove("divya@gmail.com"));
        System.out.println("After removal: " + registeredEmails);
        
        Set<String> newBranchEmails = new HashSet<>();
        newBranchEmails.add("anita@gmail.com");
        newBranchEmails.add("kumar@gmail.com");
        newBranchEmails.add("arun@gmail.com"); // duplicate across branch
        
        registeredEmails.addAll(newBranchEmails);
        System.out.println(" \n After addAll registeredEmails "+registeredEmails);
        
        Set<String> deleteRequests = new HashSet<>();
        deleteRequests.add("kumar@gmail.com");
        deleteRequests.add("arun@gmail.com");

        registeredEmails.removeAll(deleteRequests);
        System.out.println("After removeAll (bulk delete): " + registeredEmails);
        
        Set<String> paidUsers = new HashSet<>();
        paidUsers.add("anita@gmail.com");
        paidUsers.add("premium@gmail.com");

        registeredEmails.retainAll(paidUsers);
        System.out.println("\nAfter retainAll (keep only paid users): " + registeredEmails);
        
        
        registeredEmails.clear();
	}

}
