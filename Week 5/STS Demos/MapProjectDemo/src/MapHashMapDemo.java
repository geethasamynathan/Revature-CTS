import java.util.*;
public class MapHashMapDemo {

	public static void main(String[] args) {
		
		Map<String,Integer> priceMap=new HashMap<>();
		
		priceMap.put("P1001",50000);
		priceMap.put("P1002",1500);
		priceMap.put("P1003",2500);
		
		priceMap.put("P1002",1700);
		
		System.out.println("Map : "+priceMap);
		
		// size(), isEmpty()
        System.out.println("Total products: " + priceMap.size());
        System.out.println("Is empty? " + priceMap.isEmpty());

        // get()
        System.out.println("Price of P1001: " + priceMap.get("P1001"));

        // getOrDefault()
        System.out.println("Price of P9999: " + priceMap.getOrDefault("P9999", 0));
        
     // containsKey(), containsValue()
        System.out.println("Has P1003? " + priceMap.containsKey("P1003"));
        System.out.println("Has price 50000? " + priceMap.containsValue(50000));

        // putIfAbsent()
        priceMap.putIfAbsent("P1003", 3000); // will NOT change (already present)
        priceMap.putIfAbsent("P1004", 999);  // will add
        System.out.println("After putIfAbsent: " + priceMap);
        
     // replace()
        priceMap.replace("P1001", 52000);
        System.out.println("After replace P1001: " + priceMap);

        // replace(key, old, new)
        boolean replaced = priceMap.replace("P1002", 1700, 1800);
        System.out.println("Replace P1002 if old=1700? " + replaced);
        System.out.println("After conditional replace: " + priceMap);

        // remove(key)
        priceMap.remove("P1004");
        System.out.println("After remove P1004: " + priceMap);
        
     // computeIfAbsent() - create value if missing
        priceMap.computeIfAbsent("P2000", k -> 1111);
        System.out.println("After computeIfAbsent: " + priceMap);

        // computeIfPresent() - update only if present
        priceMap.computeIfPresent("P1001", (k, v) -> v + 2000);
        System.out.println("After computeIfPresent P1001: " + priceMap);

        // compute() - runs for present or absent
        priceMap.compute("P3000", (k, v) -> (v == null) ? 3333 : v + 1);
        System.out.println("After compute P3000: " + priceMap);
        
     // merge() - great for counts / totals
        // If key absent -> sets value
        // If key present -> combines old and new using function
        priceMap.merge("P1002", 200, Integer::sum);
        System.out.println("After merge P1002 (+200): " + priceMap);

        // keySet(), values(), entrySet()
        System.out.println("Keys: " + priceMap.keySet());
        System.out.println("Values: " + priceMap.values());

        System.out.println("Entries using entrySet:");
        for (Map.Entry<String, Integer> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // forEach()
        System.out.println("Using forEach:");
        priceMap.forEach((k, v) -> System.out.println("Product " + k + " price " + v));
        
     // clear()
        priceMap.clear();
        System.out.println("After clear: " + priceMap);

	}

}
