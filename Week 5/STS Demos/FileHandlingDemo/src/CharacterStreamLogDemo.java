import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class CharacterStreamLogDemo {

    public static void main(String[] args) {

        String logFilePath = "C:\\New Folder\\app-log.txt";
        File logFile = new File(logFilePath);

        // ✅ 0) CREATE NEW FILE (if not exists)
        try {
            // Ensure parent folder exists
            File parent = logFile.getParentFile();
            if (parent != null && !parent.exists()) {
                boolean folderCreated = parent.mkdirs();
                System.out.println("📁 Folder created: " + folderCreated);
            }

            // Create file if it doesn't exist
            if (!logFile.exists()) {
                boolean fileCreated = logFile.createNewFile();
                System.out.println("📄 New file created: " + fileCreated + " -> " + logFilePath);
            } else {
                System.out.println("📄 File already exists: " + logFilePath);
            }

        } catch (IOException e) {
            System.out.println("❌ File creation error: " + e.getMessage());
            return; // stop program if file cannot be created
        }

        // ✅ 1) WRITE TEXT (Writer) - Append Mode
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(logFile, true), // true = append mode
                                     StandardCharsets.UTF_8))) {

            writer.write("✅ Login Success - User: Geetha - "+new Date().toString());
            writer.newLine();
            writer.write("🔥 Payment processed - Amount: ₹500");
            writer.newLine();
          

            System.out.println("✅ Log written to: " + logFilePath);

        } catch (IOException e) {
            System.out.println("❌ Write error: " + e.getMessage());
        }

        // ✅ 2) READ TEXT (Reader)
        System.out.println("\n---- Reading log file ----");
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(logFile),
                                     StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("❌ Read error: " + e.getMessage());
        }

        // ✅ 3) DELETE FILE (optional)
        // Real world: Delete temporary file after processing
        System.out.println("\nDo you want to delete the log file? (Y/N)");

        try {
            int choice = System.in.read(); // reads one character
            if (choice == 'Y' || choice == 'y') {

                boolean deleted = logFile.delete();
                if (deleted) {
                    System.out.println("🗑️ File deleted successfully: " + logFilePath);
                } else {
                    System.out.println("❌ File not deleted. It may be open in another program.");
                }

            } else {
                System.out.println("✅ File kept: " + logFilePath);
            }

        } catch (IOException e) {
            System.out.println("❌ Error reading input: " + e.getMessage());
        }
    }
}
