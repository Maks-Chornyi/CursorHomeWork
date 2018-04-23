package department;

import java.util.Random;

public class DutyMan {
    public static boolean fireOrNot(){
        boolean bool = false;
        if(new Random().nextInt(2)==0)
            bool = true;
        return bool;
    }
}
