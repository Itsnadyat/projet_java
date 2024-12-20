package entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id; 
    private String surname; 
    private String prenom; 
    private String telephone; 
    private String address; 
    private List<Dette> dettes; 

    
    public Client() {
        this.dettes = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Dette> getDettes() {
        return dettes;
    }

    public void addDette(Dette dette) {
        this.dettes.add(dette);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", dettes=" + dettes.size() +
                '}';
    }
}
