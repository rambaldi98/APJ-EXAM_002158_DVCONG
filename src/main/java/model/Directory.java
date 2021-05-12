package model;

import java.time.LocalDate;

public class Directory {


    private String phoneNumber;
    private String group;
    private String name;
    private Gender gender;
    private String address;
    private String birthday;
    private String email;


    public Directory() {

    }

    public Directory(String phoneNumber, String group, String name, Gender gender, String address, String birthday, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                 phoneNumber + "\t\t\t"
                + name +"\t\t\t"
                + group + "\t\t\t"
                + gender +"\t\t\t"
                + address + "\t\t\t"
                + birthday +"\t\t\t"
                + email +"\t\t\t";

    }
}
