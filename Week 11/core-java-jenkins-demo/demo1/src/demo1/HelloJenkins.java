package demo1;

public class  HelloJenkins {
	 public static void main(String[] args) {
	        System.out.println("✅ Hello from Jenkins CI/CD Demo!");
	        
	        System.out.println(BuildInfo.getBuildMessage());
	        BuildInfo.printWelcome("Team");
	        System.out.println("Build time: " + java.time.LocalDateTime.now());
	    }
}
