import java.io.*;
import java.util.ArrayList;


public class AppData {
    private String[] header;
    private Integer[][] data;


    public AppData() {
    }

    public String[] getHeader() {
        return header;
    }


    public Integer[][] getData() {
        return data;
    }


    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowToString(header));

            for (Integer[] row : data) {
                writer.write(rowToString(row));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private <T> String rowToString(T[] row) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < row.length; i++) {
            result.append(row[i].toString());
            if (i != row.length - 1) {
                result.append(";");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public void load(String fileName) {
        try (BufferedReader buffReader = new BufferedReader(new FileReader(fileName))) {
            header = buffReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = buffReader.readLine()) != null) {
                dataList.add(stringToDataRow(tempString));
            }
            data = dataList.toArray(new Integer[][]{{}});

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Integer[] stringToDataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
