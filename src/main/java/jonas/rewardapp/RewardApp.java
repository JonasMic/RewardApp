package jonas.rewardapp;


import jonas.rewardapp.service.RewardService;
import jonas.rewardapp.utility.UserInput;

public class RewardApp {

    public static void main(String[] args) {
        System.out.println("*******************************************Welcome to the Reward app.U are on the right spot to claim or redeem your rewards !!! ***************** \n \n");
        UserInput userInput = new UserInput();
        userInput.register();
        userInput.login();

        


    }

}
