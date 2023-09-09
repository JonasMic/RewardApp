package jonas.rewardapp.service;

import jonas.rewardapp.entity.Customer;
import jonas.rewardapp.entity.Redemption;
import jonas.rewardapp.exception.InvalidUserInputException;
import jonas.rewardapp.utility.UserInput;
import jonas.rewardapp.utility.UserInputInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RewardService implements Runnable, UserInputInterface {
    private List<Customer> customersList;
    private Customer currentCustomer;
    private String hasClaimed;


    public RewardService() {
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    public String getHasClaimed() {
        return hasClaimed;
    }

    public void setHasClaimed(String hasClaimed) {
        this.hasClaimed = hasClaimed;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
    // get the list of customers,
    // generate random integer for the id
    // check the generated Id is the id of the current customer.
    // create instance of the current user and add random number rewards to the customer
    // show the customer the available list of coupons and if he wants to redeem for the coup he wants
    // ask the customer if he wants to redeem his rewards
    // show and allow the available list of redemption types and their corresponding reward pon value

    public Customer getCurrentUser() {

        UserInput userInput = new UserInput();
        setCurrentCustomer(userInput.getCurrentCustomer());
        return currentCustomer;
    }

    public List<Customer> getCustomerList() {
        currentCustomer = getCurrentUser();
        List<Customer> existingCustomers = new UserInput().getCustomersList();
        List<Customer> updatedCustomerList = new ArrayList<>();
        existingCustomers.stream().
                forEach(e -> updatedCustomerList.add(e));
        updatedCustomerList.add(currentCustomer);
        setCustomersList(updatedCustomerList);
        return customersList;
    }

    //
    public long surchargeRewards() {
        // this method is to be repeatedly to be called at the background and surcharge Rewards
        currentCustomer = getCurrentUser();
        int randomRewardPoint = getRandomNumber(2000, 20_000);
        currentCustomer.setRewardPoints(currentCustomer.getRewardPoints() + randomRewardPoint);
        return currentCustomer.getRewardPoints();

    }

    public void claimRewards(Customer customer) {
        List<Redemption> redemptionList = new ArrayList<>();
        Redemption redemption = new Redemption();
        List<Redemption> availableRedeem = new ArrayList<>();
        availableRedeem.addAll(redemption.getRedemptionList());
        long rewardPoints = surchargeRewards();
        System.out.println("congratulation ! .You have total reward points of : " + rewardPoints);
        System.out.println("And here are the list of rewards below to redeem based on on your reward points");
        List<String> giftList = new ArrayList<>();

        redemption.getRedemptionList()
                .stream()
                .forEach((r) -> {
                    giftList.add(r.getName() + " and the required reward points are : " + r.getRewardPointValue() + " .");
                });
        for (int i = 0; i < giftList.size(); i++) {
            System.out.println((i + 1) + "-" + giftList.get(i));

        }
        System.out.println("Do you want redeem your  " + rewardPoints + " reward points now.");
        System.out.println("Enter y for yes or n for no");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("y")) {
            try {
                System.out.println("Input 1 for Amazon gift card");
                System.out.println("Input 2 for Travel gift card");
                System.out.println("Input 3 for Headphone");
                System.out.println("Input 4 for T-shirts");
                int input1 = scan.nextInt();
                if (1 == input1) {
                    if (rewardPoints >= availableRedeem.get(input1 - 1).getRewardPointValue()) {

                        System.out.println("Wow congratulation you redemption for " + availableRedeem.get(input1 - 1).getName() + " is successful.");
                        customer.setRewardPoints(customer.getRewardPoints() - availableRedeem.get(input1 - 1).getRewardPointValue());
                    } else {
                        System.out.println("Sorry your reward points,  : " + rewardPoints + "are not enough to redeem " + availableRedeem.get(input1 - 1).getName() + " which require "
                                + availableRedeem.get(input1 - 1).getRewardPointValue() + ".Try to redeem other reward");
                    }
                } else if (2 == input1) {
                    if (rewardPoints >= availableRedeem.get(input1).getRewardPointValue()) {
                        System.out.println("Wow congratulation you redemption for " + availableRedeem.get(input1 - 1).getName() + " is successful.");
                        customer.setRewardPoints(customer.getRewardPoints() - availableRedeem.get(input1 - 1).getRewardPointValue());
                    } else {
                        System.out.println("Sorry your reward points,  : " + rewardPoints + "are not enough to redeem " + availableRedeem.get(input1 - 1).getName() + " which require "
                                + availableRedeem.get(input1 - 1).getRewardPointValue() + ". Try to redeem other reward");
                    }

                } else if (3 == input1) {
                    if (rewardPoints >= availableRedeem.get(input1).getRewardPointValue()) {
                        System.out.println("Wow congratulation you redemption for " + availableRedeem.get(input1 - 1).getName() + " is successful.");
                        customer.setRewardPoints(customer.getRewardPoints() - availableRedeem.get(input1 - 1).getRewardPointValue());
                    } else {
                        System.out.println("Sorry your reward points,  : " + rewardPoints + "are not enough to redeem " + availableRedeem.get(input1 - 1).getName() + " which require "
                                + availableRedeem.get(input1 - 1).getRewardPointValue() + ". Try to redeem other reward");
                    }

                } else if (4 == input1) {
                    if (rewardPoints >= availableRedeem.get(input1 - 1).getRewardPointValue()) {
                        System.out.println("Wow congratulation you redemption for " + availableRedeem.get(input1 - 1).getName() + " is successful.");
                        customer.setRewardPoints(customer.getRewardPoints() - availableRedeem.get(input1 - 1).getRewardPointValue());
                    } else {
                        System.out.println("Sorry your reward points,  : " + rewardPoints + "are not enough to redeem " + availableRedeem.get(input1 - 1).getName() + " which require "
                                + availableRedeem.get(input1 - 1).getRewardPointValue() + ". Try to redeem other reward");
                    }

                } else {
                    throw new InvalidUserInputException("invalid input");
                }


            } catch (InvalidUserInputException ex) {
                System.out.println(ex.getMessage());
            }

//        validationBlock();

        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Thank you for using the reward App.You have " + rewardPoints + " reward points and you can claim yours reward any time next by vising the Reward app");

        } else {
            System.out.println("Invalid Input");
            throw new InvalidUserInputException("Invalid input");
        }

    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter yes or no .");
        setHasClaimed(scan.nextLine());
        ;
    }

    public void validateInput() throws InvalidUserInputException {
        if ("yes".equalsIgnoreCase(getHasClaimed())) {
            System.out.println("welcome");
        } else if ("no".equalsIgnoreCase(getHasClaimed())) {
            System.out.println("Thanks.See you later !!");
            System.exit(1);

        } else {
            InvalidUserInputException invalidUserInputException = new InvalidUserInputException("Invalid Input. please input what is required");
            System.out.println(invalidUserInputException.getMessage());
            throw invalidUserInputException;
        }
    }

    @Override
    public void validationBlock() {
        try {
            input();
            validateInput();
        } catch (InvalidUserInputException e) {
            try {
                input();
                validateInput();
            } catch (InvalidUserInputException ex) {
                try {
                    input();
                    validateInput();
                } catch (InvalidUserInputException exc) {
                    exc.printStackTrace();
                    System.out.println("Please try again later");
                }
            }
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void run() {

    }


}
