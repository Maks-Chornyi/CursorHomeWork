package department;

public class Administrator {
    public void callToDutyMan(){
        if(DutyMan.fireOrNot())
            System.out.println("There is fire");
        else
            sendCrew();
    }

    private void sendCrew(){

    }
}
