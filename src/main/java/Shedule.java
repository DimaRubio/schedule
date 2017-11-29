import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by dmytro.bolyachin on 29.11.17.
 */
public class Shedule {
    public static void main(String[] args) {
        String startDate = "01.10.2017";
        String currentDate = enterDate();
        getWatch(startDate, currentDate);
    }

    private static String enterDate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a date in following format \"dd.MM.yyyy\":");
        return in.nextLine();
    }

    private static void getWatch(String startDate, String currentDate) {
        Date dateOne = convertDate(startDate);
        Date dateTwo = convertDate(currentDate);
        long difference = dateTwo.getTime() - dateOne.getTime();
        int day = 24 * 60 * 60 * 1000;
        int dif = (int)(difference / (day)) % 5;
        switch (dif) {
            case 0:
                System.out.println(currentDate + " - \"1 watch\"");
                break;
            case 1:
                System.out.println(currentDate +" - \"2 watch, night\"");
                break;
            case 2:
                System.out.println(currentDate +" - \"2 watch, morning\"");
                break;
            case 3:
            case 4:
                System.out.println(currentDate + " - \"weekend\"");
                break;
        }
    }

    private static Date convertDate(String startDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(startDate);
        } catch (Exception e) {
            System.out.println("incorrect date");
            e.printStackTrace();
        }
        return date;
    }
}

