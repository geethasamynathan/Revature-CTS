import java.util.*;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		Set<String> visitors = new LinkedHashSet<>();

        visitors.add("Gopi");
        visitors.add("Anita");
        visitors.add("Ravi");
        visitors.add("Anita"); // duplicate - ignored

        System.out.println("Unique visitors in visit order: " + visitors);

        System.out.println("Total unique visitors"+visitors.size());
        
        System.out.println("Did Kumar visit? " + visitors.contains("Kumar"));
        
        System.out.println("\nRemove Ravi: " + visitors.remove("Ravi"));
        System.out.println("After removing Ravi: " + visitors);
        

        // 6) addAll() - Merge visitors from another counter/day
        Set<String> day2Visitors = new LinkedHashSet<>();
        day2Visitors.add("Divya");
        day2Visitors.add("Gopi");   // duplicate
        day2Visitors.add("Mubeen");

        visitors.addAll(day2Visitors);
        System.out.println("\nAfter addAll (merge day2 visitors): " + visitors);

        // 7) removeAll() - Remove multiple visitors (blocked list / invalid entries)
        Set<String> blocked = new LinkedHashSet<>();
        blocked.add("Anita");
        blocked.add("Unknown"); // not present

        visitors.removeAll(blocked);
        System.out.println("After removeAll (blocked removed): " + visitors);

        // 8) retainAll() - Keep only common visitors (intersection use-case)
        Set<String> vipVisitors = new LinkedHashSet<>();
        vipVisitors.add("Gopi");
        vipVisitors.add("Divya");

        visitors.retainAll(vipVisitors);
        System.out.println("\nAfter retainAll (keep only VIP visitors): " + visitors);

        // 9) iterator() - Traverse in same insertion order
        System.out.println("\nTraverse visitors using Iterator:");
        Iterator<String> it = visitors.iterator();
        while (it.hasNext()) {
            System.out.println("Visitor -> " + it.next());
        }

        // 10) toArray() - Convert to array (for reports/export)
        Object[] arr = visitors.toArray();
        System.out.println("\nVisitors converted to Array: " + Arrays.toString(arr));

        // 11) clear() - Reset (end of day)
        visitors.clear();
        System.out.println("\nAfter clear(): " + visitors);
        System.out.println("Is empty after clear? " + visitors.isEmpty());
	}

}
