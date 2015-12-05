/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.beans.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Address;
    private String City;
    private String State;
    private String Zipcode;
    private String Email;
    private String Username;
    private String Password;
    private Account savings;
    private Account checking;

    public User(String FirstName, String LastName, String Phone, String Address, String City, String State, String Zipcode, String Email, String Username, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Zipcode = Zipcode;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.savings = new Account(Account.Type.SAVINGS, 25.00, this);
        this.checking = new Account(Account.Type.CHECKING, 0.00, this);
    }

    public User() {
        this.FirstName = "";
        this.LastName = "";
        this.Phone = "";
        this.Address = "";
        this.City = "";
        this.State = "";
        this.Zipcode = "";
        this.Email = "";
        this.Username = "";
        this.Password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public void depositFounds(double amt, Account.Type type){
        if(type.equals(Account.Type.CHECKING)){
            this.checking.credit(amt);
        }
    }
    
}
