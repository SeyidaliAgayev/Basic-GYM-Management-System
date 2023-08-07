package helper;

import data.GlobalData;
import enums.ExceptionEnums;
import enums.StatusEnums;
import exception.LackOfDepartures;
import exception.WrongFormat;
import model.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static util.InputUtil.*;
import static util.InputUtil.*;

public class ServiceHelper {
    static int countIndex = 0;
    private static long id = 0;
    public static Member fillMember() {
        try {
            String name = requiredStringInput("Enter the name: ");
            String surname = requiredStringInput("Enter the surname: ");
            String fin = requiredStringInput("Enter the FIN: ");
            String serialNumber = requiredStringInput("Enter the serial number(passport): ");
            LocalDate expirationDate = dateServiceHelper();
            LocalDateTime registerDate = LocalDateTime.now();
            LocalDate updateDate = null;
            double memberAmount = requiredDoubleInput("Enter the amount of member: ");
            return new Member(++id,name,surname,fin,serialNumber,12,expirationDate,registerDate, null,memberAmount);
        } catch (WrongFormat exception) {
            System.out.println(exception.getMessage());
            return null;
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public static LocalDate dateServiceHelper() {
        try {
            String str1 = requiredStringInput("Enter the expiration Date(day-month-years): ");
            String[] str2 = str1.split("-");
            int day = Integer.parseInt(str2[0]);
            int month = Integer.parseInt(str2[1]);
            int years = Integer.parseInt(str2[2]);
            return LocalDate.of(day, month, years);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
    public static void memberRegisterHelper() {
        Member member = fillMember();
        if (member != null) {
            GlobalData.members[countIndex] = member;
            countIndex++;
        }
    }
    public static void gymTakeHelper(int id) {
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.members.length; i++) {
            if (GlobalData.members[i].getNumberOfDepartures() > 0 && GlobalData.members[i].getId() == id) {
                GlobalData.members[i].setNumberOfDepartures(GlobalData.members[i].getNumberOfDepartures() - 1);
                isTrue = true;
            }
        }
        System.out.println(StatusEnums.LOG_IN_SUCCESSFULLY);
        if (!isTrue) {
            throw new LackOfDepartures(ExceptionEnums.LACK_OF_DEPARTURES);
        }
    }
    public static void updateHelper() {
        int inputId = requiredIntInput("Enter the ID of member to update: ");
        String inputFinUpdate = requiredStringInput("Enter the FIN number to update departures: ");
        int addNumberOfDepartures = requiredIntInput("Enter number of departures to add: ");
        LocalDate updateDate = dateServiceHelper();
        for (int i = 0; i < GlobalData.members.length; i++) {
            if (GlobalData.members[i].getFin().equals(inputFinUpdate)
            && GlobalData.members[i].getId() == inputId) {
                GlobalData.members[i].setNumberOfDepartures(GlobalData.members[i].getNumberOfDepartures() + addNumberOfDepartures);
                System.out.println(updateDate);
                System.out.println(GlobalData.members[i].getName() + " " +
                        GlobalData.members[i].getSurname() + "-" + StatusEnums.DEPARTURE_UPDATED_SUCCESSFULLY);
            }
        }
    }
}
