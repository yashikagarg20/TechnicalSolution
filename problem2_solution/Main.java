import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    

    public static void main(String[] args) {
        int countNameT = 0;
        int countNameS = 0;

        BufferedReader br = null;
        try {
            //Read the input file
            File file = new File("small.dat"); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
                //Counting files for each directory structure
                Map<String, Integer> countForfiles = getCountOfFilesFromDirectory(line);
                countNameT = countNameT + countForfiles.get("tCount");
                countNameS = countNameS + countForfiles.get("sCount");
            }
            System.out.println(countNameT);
            System.out.println(countNameS);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, Integer> getCountOfFilesFromDirectory(String dirPath) {
        String[] fileStructure = dirPath.split(" ");
        Map<String, Integer> countForfiles = new HashMap<String, Integer>();
        int counterT = 0;
        int counterS = 0;
        for (int i = 0; i < fileStructure.length; i++) {
            String fileName = fileStructure[i];

            //Assuming upper case are of file only
            if (fileName.toUpperCase().equals(fileName)) {
                // Count for T
                if (fileName.startsWith("T")) {
                    counterT++;
                }
                // Count for S
                if (fileName.endsWith("S")) {
                    counterS++;
                }
            }
        }
        countForfiles.put("tCount", counterT);
        countForfiles.put("sCount", counterS);
        return countForfiles;
    }

}