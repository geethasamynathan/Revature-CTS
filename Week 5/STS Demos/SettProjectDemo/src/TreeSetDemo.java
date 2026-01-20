import java.util.*;
public class TreeSetDemo {

	public static void main(String[] args) {
        NavigableSet<Integer> productIds = new TreeSet<>();

        productIds.add(105);
        productIds.add(101);
        productIds.add(110);
        productIds.add(105); // duplicate

        System.out.println("Sorted unique IDs: " + productIds); // [101, 105, 110]
        System.out.println("First (min): " + productIds.first());
        System.out.println("Last (max): " + productIds.last());
        System.out.println("IDs <= 106: " + productIds.headSet(106, true));
        System.out.println("Next ID after 105: " + productIds.higher(105));


	}

}
