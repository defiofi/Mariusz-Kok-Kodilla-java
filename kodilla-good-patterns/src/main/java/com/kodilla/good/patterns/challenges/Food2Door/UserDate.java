package com.kodilla.good.patterns.challenges.Food2Door;

public class UserDate {
    private String name;
    private String surname;
    private String pesel;
    private String mail;

    public UserDate(String name, String surname, String pesel, String mail) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.mail = mail;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDate userDate = (UserDate) o;

        if (name != null ? !name.equals(userDate.name) : userDate.name != null) return false;
        if (surname != null ? !surname.equals(userDate.surname) : userDate.surname != null) return false;
        if (pesel != null ? !pesel.equals(userDate.pesel) : userDate.pesel != null) return false;
        return mail != null ? mail.equals(userDate.mail) : userDate.mail == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }
}

