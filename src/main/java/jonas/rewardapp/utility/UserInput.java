package jonas.rewardapp.utility;

import jonas.rewardapp.entity.Customer;
import jonas.rewardapp.exception.InvalidUserInputException;
import jonas.rewardapp.service.RewardService;

import java.util.*;

public class UserInput extends Customer {
    private String hasAccount;
    private int id;
    private String name;
    private String email;
    private String password;

    private static Customer currentCustomer;


    public UserInput(String hasAccount, int id, String name, String email, String password) {
        this.hasAccount = hasAccount;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserInput(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserInput() {
        super();
        this.hasAccount = "no";
    }

    public String isHasAccount() {
        return hasAccount;
    }

    public void setHasAccount(String hasAccount) {
        this.hasAccount = hasAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    static Scanner scan = new Scanner(System.in);


    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public void input() {
        System.out.println("Do you have an account ? enter Yes or No");
        setHasAccount(scan.nextLine());
    }

    public void validateInput() throws InvalidUserInputException {
        if ("yes".equalsIgnoreCase(isHasAccount())) {
            System.out.println("welcome to Rewards App.Please login.");
            login();
        } else if ("no".equalsIgnoreCase(isHasAccount())) {
            try {
                System.out.println("Let's start registration");
                System.out.println("please enter your name");
                String name = scan.nextLine();
                if (name.length() < 1) {
                    throw new InvalidUserInputException("Please enter valid name with more than one character");
                } else {
                    setName(name);
                }

            } catch (InvalidUserInputException ex) {
                try {
                    System.out.println("Please enter again a valid name with more than one character");
                    String name = scan.nextLine();
                    if (name.length() < 1) {
                        ex.getMessage();
                        throw new InvalidUserInputException("please enter valid name with more than one character");
                    } else {
                        setName(name);
                    }

                } catch (InvalidUserInputException exe) {
                    try {
                        System.out.println("Please enter again a valid name with more than one character");
                        String name = scan.nextLine();
                        if (name.length() < 1) {
                            throw new InvalidUserInputException("please try again later");
                        } else {
                            setName(name);
                        }

                    } catch (InvalidUserInputException e) {
                        System.out.println(e.getMessage());
                        System.exit(1);

                    }

                }

            }

//----------------------------
            try {
                System.out.println("please enter your email");
                String email = scan.nextLine();
                if (email.length() < 1) {
                    throw new InvalidUserInputException("Please enter valid email with more than one character");
                } else {
                    setEmail(email);
                }

            } catch (InvalidUserInputException ex) {
                try {
                    System.out.println("Please enter again a valid email with more than one character");
                    String email = scan.nextLine();
                    if (email.length() < 1) {
                        ex.getMessage();
                        throw new InvalidUserInputException("please enter valid email with more than one character");
                    } else {
                        setEmail(email);
                    }

                } catch (InvalidUserInputException exe) {
                    try {
                        System.out.println("Please enter again a valid email with more than one character\"");
                        String email = scan.nextLine();
                        if (email.length() < 1) {
                            throw new InvalidUserInputException("please try again later");
                        } else {
                            setEmail(email);
                        }

                    } catch (InvalidUserInputException e) {
                        System.out.println(e.getMessage());
                        System.exit(1);

                    }

                }

            }
//            ----------------
            try {
                System.out.println("please enter your password");
                String password = scan.nextLine();
                if (password.length() < 4) {
                    throw new InvalidUserInputException("Please enter valid password with more than one character");
                } else {
                    setPassword(password);
                    Customer customer = new Customer(super.getCustomersList().size() + 1, getName(), getEmail(), getPassword());
                    setCurrentCustomer(customer);
                    List<Customer> customerList = super.getCustomersList();
                    customerList.add(customer);
                  super.setCustomersList(customerList);
                    System.out.println(super.getCustomersList());

                }

            } catch (InvalidUserInputException ex) {
                try {
                    System.out.println("Please enter again a valid password with more than four character");
                    String password = scan.nextLine();
                    if (password.length() < 4) {
                        ex.getMessage();
                        throw new InvalidUserInputException("please enter valid password with more than four character");
                    } else {
                        setPassword(password);
                        Customer customer = new Customer(super.getCustomersList().size() + 1, getName(), getEmail(), getPassword());
                        setCurrentCustomer(customer);
                        List<Customer> customerList = super.getCustomersList();
                        customerList.add(customer);
                        super.setCustomersList(customerList);
                        System.out.println(super.getCustomersList());

                    }

                } catch (InvalidUserInputException exe) {
                    try {
                        System.out.println("Please enter again a valid password with more than four character\"");
                        String password = scan.nextLine();
                        if (password.length() < 4) {
                            throw new InvalidUserInputException("please try again later");
                        } else {
                            setPassword(password);
                            Customer customer = new Customer(super.getCustomersList().size() + 1, getName(), getEmail(), getPassword());
                            setCurrentCustomer(customer);
                            List<Customer> customerList = super.getCustomersList();
                            customerList.add(customer);
                            super.setCustomersList(customerList);
                            System.out.println(super.getCustomersList());

                        }

                    } catch (InvalidUserInputException e) {
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }

                }
            }
        } else {
            InvalidUserInputException invalidUserInputException = new InvalidUserInputException("Invalid Input. please input what is required");
            System.out.println(invalidUserInputException.getMessage());
            throw invalidUserInputException;
        }

    }
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
                    System.out.println(" You have  tried three times .Please try again later");
                }
            }
        }
    }

    public void register() throws InvalidUserInputException {
        validationBlock();
    }

    public void login() {
        Optional<Customer> customer = Optional.ofNullable(getCurrentCustomer());
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Login ");

        System.out.println("Enter your email : ");
        String email = scan.nextLine();
        System.out.println("Enter your password : ");
        String password = scan.nextLine();

        try {
            if (customer.get().getEmail().equals(email) && customer.get().getPassword().equals(password)) {
                System.out.println("Welcome to the Rewards App .You are successfully logged in");
                RewardService service= new RewardService();
               service.surchargeRewards();
                // retrieve email from the record by email
                service.claimRewards(currentCustomer);
            } else {
                throw new InvalidUserInputException(" Invalid  password or email input!");
            }

        } catch (InvalidUserInputException | NoSuchElementException ne) {
            try {
                System.out.println("Enter your email again : ");
                email = scan.nextLine();
                System.out.println("Enter your password again : ");
                password = scan.nextLine();
                if (customer.get().getEmail().equals(email) && customer.get().getPassword().equals(password)) {
                    System.out.println("Welcome to the Rewards App .You are successfully logged in");
                    RewardService service= new RewardService();
                    service.surchargeRewards();
                    // retrieve email from the record by email
                    service.claimRewards(currentCustomer);

                } else {
                    throw new InvalidUserInputException(" Invalid  password or email input!");
                }

            } catch (InvalidUserInputException | NoSuchElementException e) {
                try {
                    System.out.println("Enter your email again : ");
                    email = scan.nextLine();
                    System.out.println("Enter your password  again: ");
                    password = scan.nextLine();
                    if (customer.get().getEmail().equals(email) && customer.get().getPassword().equals(password)) {
                        System.out.println("Welcome to the Rewards App .You are successfully logged in");
                        RewardService service= new RewardService();
                        service.surchargeRewards();
                        // retrieve email from the record by email
                        service.claimRewards(currentCustomer);

                    } else {
                        throw new NoSuchElementException(" Sorry Invalid user account,you tried three times.Please try again later!");
                    }
                } catch (InvalidUserInputException | NoSuchElementException exc) {
                    System.out.println(exc.getMessage());
                    System.exit(0);
                }

            }

        }

    }


}
