import java.util.*;
public class EnumSetDemo {

	public static void main(String[] args) {
		enum Permission { READ, WRITE, DELETE, EXPORT }

	   
	        Set<Permission> staff = EnumSet.of(Permission.READ, Permission.WRITE);
	        Set<Permission> admin = EnumSet.allOf(Permission.class);

	        System.out.println("Staff permissions: " + staff);
	        System.out.println("Admin permissions: " + admin);

	        System.out.println("Can staff delete? " + staff.contains(Permission.DELETE));

	}

}
