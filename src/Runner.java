import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setFirstName("bilal");
        customer1.setLastName("cricket");
        customer1.setUserId("bilal");
        customer1.setPin(1234);
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("faraz");
        customer2.setLastName("fastbowler");
        customer2.setUserId("faraz");
        customer2.setPin(1234);
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("saad");
        customer3.setLastName("keeper");
        customer3.setUserId("saad");
        customer3.setPin(1234);
        customers.add(customer3);

        try {
            FileOutputStream file = new FileOutputStream("customer.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(customers);
            outputStream.flush();
            outputStream.close();
        } catch (IOException notfound) {
            notfound.printStackTrace();
        }

        try {
            FileInputStream readData = new FileInputStream("customer.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList inputCustomer = (ArrayList<Customer>) readStream.readObject();
            readStream.close();

            System.out.println(inputCustomer.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

