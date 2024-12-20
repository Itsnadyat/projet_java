package entity;

public class Dette {
    private int id; 
    private String date; 
    private double montant; 
    private double montantVerser;
    private double montantRestant; 
    private Client client; 

    
    public Dette() {}

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantVerser() {
        return montantVerser;
    }

    public void setMontantVerser(double montantVerser) {
        this.montantVerser = montantVerser;
    }

    public double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dette{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", montant=" + montant +
                ", montantVerser=" + montantVerser +
                ", montantRestant=" + montantRestant +
                ", client=" + (client != null ? client.getId() : "Aucun") +
                '}';
    }
}
