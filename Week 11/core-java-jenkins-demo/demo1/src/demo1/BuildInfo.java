package demo1;


import java.time.LocalDateTime;

public class BuildInfo {
	 public static String getBuildMessage() {
	        return "Build generated at: " + LocalDateTime.now();
	    }
	 public static void printWelcome(String name) {
	        System.out.println("Welcome " + name + " 🚀 - Jenkins pipeline executed successfully!");
	    }
	 
}
