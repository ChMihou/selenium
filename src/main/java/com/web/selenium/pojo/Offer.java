package com.web.selenium.pojo;

import java.io.Serializable;

public class Offer implements Serializable {

    private static final long serialVersionUID = 2288735996591764103L;

    private String cardNumber;

    private String LastName;

    private String name;

    private String year;

    private String month;

    private String day;

    private String cvv;

    private String postcode;

    private String country;

    private String Address;

    private String cc;

    private String email;

    private String phone;

    private String state;

    private String submit1;

    private String submit2;

    private String url;

    private Integer typeOffer;

    private String realPhone;

    public String getRealPhone() {
        return realPhone;
    }

    public void setRealPhone(String realPhone) {
        this.realPhone = realPhone;
    }

    public Integer getTypeOffer() {
        return typeOffer;
    }

    public void setTypeOffer(Integer typeOffer) {
        this.typeOffer = typeOffer;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSubmit1() {
        return submit1;
    }

    public void setSubmit1(String submit1) {
        this.submit1 = submit1;
    }

    public String getSubmit2() {
        return submit2;
    }

    public void setSubmit2(String submit2) {
        this.submit2 = submit2;
    }

    public String getDay() {
        if (day == null)
            return day = "20";
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Offer(String cardNumber, String lastName, String name, String year, String month, String cvv, String postcode, String country, String address, String email, String phone, String state, String cc, String realPhone) {
        this.cardNumber = cardNumber;
        this.LastName = lastName;
        this.name = name;
        this.year = year;
        this.month = month;
        this.cvv = cvv;
        this.postcode = postcode;
        this.country = country;
        this.Address = address;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.cc = cc;
        this.realPhone = realPhone;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "cardNumber='" + cardNumber + '\'' +
                ", LastName='" + LastName + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", cvv='" + cvv + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", Address='" + Address + '\'' +
                ", cc='" + cc + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                ", submit1='" + submit1 + '\'' +
                ", submit2='" + submit2 + '\'' +
                ", url='" + url + '\'' +
                ", typeOffer=" + typeOffer +
                ", realPhone='" + realPhone + '\'' +
                '}';
    }
}
