package io.demo.evershop;

import com.demo.nopcommerce.models.User;
import com.github.javafaker.Faker;

public class DataFacker {

    public User newUser = new User();
    private String password;
    public Faker data;

    public DataFacker(Faker dataFaker) {
        this.data = dataFaker;
        password = this.data.internet().password(10, 12, true, true, true);
    }

    public void dataUser() {

        newUser.setFirstName(this.data.address().firstName());
        newUser.setLastName(this.data.address().lastName());
        newUser.setEmail(this.data.internet().emailAddress());
        newUser.setTelephone(this.data.phoneNumber().cellPhone());
        newUser.setPassword(password);
        newUser.setPasswordconfirm(password);

        System.out.println(newUser.toString());
    }

    public User getNewUser() {
        return newUser;
    }
}
