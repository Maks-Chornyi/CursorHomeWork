package department;

public class Administrator {
    public void callToDutyMan(){
        if(DutyMan.fireOrNot())
            System.out.println("There is fire");
        else
            System.out.println("There is no fire");
    }

    private void sendCrew(){

    }
}
