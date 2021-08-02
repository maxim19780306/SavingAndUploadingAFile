//1. Реализовать сохранение данных в csv файл;
//2. Реализовать загрузку данных из csv файла. Файл читается целиком.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();
        appData.load("new.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));

        appData.save("newFile.csv");

    }
}

