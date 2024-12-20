package services;

import entity.Client;
import entity.Dette;
import repositories.DetteRepository;

import java.util.List;

public class DetteServices {
    private DetteRepository detteRepository;

    public DetteServices() {
        this.detteRepository = new DetteRepository();
    }

    // Enregistrer une nouvelle dette
    public void enregistrerDette(Dette dette) {
        if (dette != null && dette.getClient() != null) {
            detteRepository.addDette(dette);
        } else {
            System.out.println("Erreur : Les informations de la dette ou du client sont manquantes.");
        }
    }

    // Lister toutes les dettes
    public void listerToutesLesDettes() {
        List<Dette> dettes = detteRepository.getAllDettes();
        if (!dettes.isEmpty()) {
            System.out.println("Liste de toutes les dettes :");
            for (Dette dette : dettes) {
                System.out.println("ID: " + dette.getId() + ", Date: " + dette.getDate() +
                        ", Montant: " + dette.getMontant() +
                        ", Montant Versé: " + dette.getMontantVerser() +
                        ", Montant Restant: " + dette.getMontantRestant() +
                        ", Client ID: " + dette.getClient().getId());
            }
        } else {
            System.out.println("Aucune dette trouvée.");
        }
    }

    // Lister les dettes non soldées
    public void listerDettesNonSoldees() {
        List<Dette> dettes = detteRepository.getUnpaidDettes();
        if (!dettes.isEmpty()) {
            System.out.println("Liste des dettes non soldées :");
            for (Dette dette : dettes) {
                System.out.println("ID: " + dette.getId() + ", Date: " + dette.getDate() +
                        ", Montant: " + dette.getMontant() +
                        ", Montant Restant: " + dette.getMontantRestant() +
                        ", Client ID: " + dette.getClient().getId());
            }
        } else {
            System.out.println("Aucune dette non soldée trouvée.");
        }
    }

    // Rechercher les dettes par le téléphone du client
    public void rechercherDettesParTelephone(String telephone, List<Client> clients) {
        boolean clientTrouve = false;
        for (Client client : clients) {
            if (client.getTelephone().equals(telephone)) {
                clientTrouve = true;
                List<Dette> dettes = detteRepository.getAllDettes();
                System.out.println("Dettes pour le client avec téléphone " + telephone + " :");
                for (Dette dette : dettes) {
                    if (dette.getClient().getId() == client.getId()) {
                        System.out.println("ID Dette: " + dette.getId() + ", Date: " + dette.getDate() +
                                ", Montant: " + dette.getMontant() +
                                ", Montant Versé: " + dette.getMontantVerser() +
                                ", Montant Restant: " + dette.getMontantRestant());
                    }
                }
                break;
            }
        }
        if (!clientTrouve) {
            System.out.println("Aucun client trouvé avec le téléphone : " + telephone);
        }
    }
}
