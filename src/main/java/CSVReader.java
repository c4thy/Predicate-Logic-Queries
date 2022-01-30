import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static int[][] read(File file) throws FileNotFoundException {
        return read(new FileInputStream(file));
    }

    public static int[][] read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<String> lines = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if(!line.isEmpty())
                lines.add(line);
        }
        scanner.close();

        int rows = lines.size();
        if(rows < 1)
            return new int[0][0];

        String[] tokens = lines.get(0).split(",");
        int cols = tokens.length;
        if(cols < 1)
            die();

        int[][] data = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            tokens = lines.get(i).split(",");
            if(tokens.length != cols)
                die();

            for(int j=0; j<cols; j++) {
                try {
                    data[i][j] = Integer.parseInt(tokens[j].trim());
                } catch (NumberFormatException e) {
                    die();
                }
            }
        }
        return data;
    }

    private static void die() {
        throw new RuntimeException("Invalid file format.");
    }
}