package jonas.rewardapp.utility;

import jonas.rewardapp.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private List<Customer> customerList;

    public Initializer() {
        customerList = new ArrayList<>();
        Customer customer1= new Customer(1,"y","y@gmail.com","y",2000);
        Customer customer2= new Customer(2,"yo","yo@gmail.com","y0",1000);
        customerList.add(customer1);
        customerList.add(customer2);


    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
