package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Member {
    private long id;
    private String name;
    private String surname;
    private String fin;
    private String serialNumber;
    private int numberOfDepartures;
    private LocalDate expirationDate;
    private LocalDateTime registerDate;
    private LocalDate updateDate;
    private double memberAmount;

    public Member() {
    }

    public Member(long id,String name, String surname, String fin, String serialNumber, int numberOfDepartures,
                  LocalDate expirationDate,LocalDateTime registerDate, LocalDate updateDate,double memberAmount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNumber = serialNumber;
        this.numberOfDepartures = 12;
        this.expirationDate = expirationDate;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.memberAmount = memberAmount;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getNumberOfDepartures() {
        return numberOfDepartures;
    }

    public void setNumberOfDepartures(int numberOfDepartures) {
        this.numberOfDepartures = numberOfDepartures;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public double getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(double memberAmount) {
        this.memberAmount = memberAmount;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id + "\'" +
                name + '\'' + surname + '\'' +
                ", FIN='" + fin + '\'' +
                ", Serial Number='" + serialNumber + '\'' +
                ", Number Of Departures=" + numberOfDepartures +
                ", Expiration Date=" + expirationDate +
                ", Register Date=" + registerDate +
                ", Update Date=" + updateDate +
                ", Member Amount=" + memberAmount +
                '}';
    }
}
