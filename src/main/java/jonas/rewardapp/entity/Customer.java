package jonas.rewardapp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Customer implements ICustomer {
    private int id;
    private String name;
    private String email;
    private String password;
    private long rewardPoints;
    private List<Redemption> redemptionList;

    private List <Customer> customersList ;

    public Customer(int id, String name, String email, String password, long rewardPoints) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rewardPoints = rewardPoints;
    }
    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Customer(){
        customersList = new ArrayList<>();
        Customer customer1 = new Customer(1, "y", "y@gmail.com", "y", 2000);
        Customer customer2 = new Customer(2, "yo", "yo@gmail.com", "y0", 1000);
        customersList.add(customer1);
        customersList.add(customer2);
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

    public long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public List<Redemption> getRedemptionList() {
        return redemptionList;
    }

    public void setRedemptionList(List<Redemption> redemptionList) {
        this.redemptionList = redemptionList;
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    @Override
    public Customer get() {
        return null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
                ", rewardPoints=" + rewardPoints +
                '}';
    }

}
