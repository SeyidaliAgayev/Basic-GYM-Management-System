package util;
import static util.InputUtil.*;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("""
                           [0]. Finish Program!
                           [1]. Register Gym Member
                           [2]. Show All Members
                           [3]. Enter the Gym
                           [4]. Update Departures
                           """
        );
        return requiredIntInput("Choose an option: ");
    }

}
