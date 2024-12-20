package services;

import java.util.ArrayList;
import java.util.List;

import entity.Client;

public class ClientServices {
    private List<Client> clients;

    public ClientServices() {
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public Client rechercherClientParTelephone(String telephone) {
        return clients.stream()
                      .filter(client -> client.getTelephone().equals(telephone))
                      .findFirst()
                      .orElse(null);
    }

    public List<Client> listerClients() {
        return clients;
    }
}