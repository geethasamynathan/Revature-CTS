package com.abc;
import java.util.*;

public class VectorDemo {
public static void main(String[] args) {
//	Vector v=new Vector();
//	for (int i=0;i<10 ;i++ )
//	{
//	v.addElement(i);
//	}
//	System.out.println(v);
//	v.addElement("rattaiah");
//	System.out.println(v);
//	v.removeElement(0);
//	System.out.println(v);
//	v.clear();
//	System.out.println(v);
	
//	Stack s=new Stack();
//	s.push("A");
//	s.push(10);
//	s.push("aaa");
//	System.out.println(s);
//	s.pop();
//	System.out.println(s);
//	System.out.println("Top Element " +s.peek());
//	System.out.println(s.search("A"));
	
	HashMap h=new HashMap();
	h.put("sambha",100);
	h.put("veeru",100);
	h.put("durga",100);
	
	System.out.println(h);
	Set s=h.keySet();
	System.out.println("Output of KeySet");
	System.out.println(s);
	Collection c=h.values();
	System.out.println(c);
	System.out.println("Output of entrySet");
	Set s1=h.entrySet();
	System.out.println(s1);
	}
	
}

