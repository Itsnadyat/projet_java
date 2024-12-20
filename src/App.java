import java.util.Scanner;
import repositories.ClientRepository;
import repositories.DetteRepository;
import entity.Client;
import entity.Dette;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ClientRepository clientRepository = new ClientRepository();
    private static DetteRepository detteRepository = new DetteRepository();

    public static void main(String[] args) {
        int choix;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Créer un client");
            System.out.println("2. Enregistrer une dette");
            System.out.println("3. Lister tous les clients");
            System.out.println("4. Lister toutes les dettes");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    createClient();
                    break;
                case 2:
                    createDette();
                    break;
                case 3:
                    listClients();
                    break;
                case 4:
                    listDettes();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 5);
    }

   
    private static void createClient() {
        Client client = new Client();

        System.out.print("Nom : ");
        client.setSurname(scanner.nextLine());

        System.out.print("Prénom : ");
        client.setPrenom(scanner.nextLine());

        System.out.print("Téléphone : ");
        client.setTelephone(scanner.nextLine());

        System.out.print("Adresse : ");
        client.setAddress(scanner.nextLine());

        clientRepository.addClient(client);
        System.out.println("Client créé avec succès !");
    }

    
    private static void createDette() {
        Dette dette = new Dette();

        System.out.print("Date (AAAA-MM-JJ) : ");
        dette.setDate(scanner.nextLine());

        System.out.print("Montant : ");
        dette.setMontant(scanner.nextDouble());

        System.out.print("Montant versé : ");
        dette.setMontantVerser(scanner.nextDouble());

        System.out.print("Montant restant : ");
        dette.setMontantRestant(scanner.nextDouble());
        scanner.nextLine(); 

        System.out.print("ID du client : ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); 

        Client client = clientRepository.getClientByTelephone(clientId);
        if (client != null) {
            dette.setClient(client);
            detteRepository.addDette(dette);
            System.out.println("Dette enregistrée avec succès !");
        } else {
            System.out.println("Erreur : Aucun client trouvé avec cet ID.");
        }
    }

   
    private static void listClients() {
        System.out.println("\n--- Liste des Clients ---");
        clientRepository.getAllClients().forEach(client -> {
            System.out.println("ID: " + client.getId() + ", Nom: " + client.getSurname() +
                               ", Prénom: " + client.getPrenom() +
                               ", Téléphone: " + client.getTelephone() +
                               ", Adresse: " + client.getAddress());
        });
    }

    
    private static void listDettes() {
        System.out.println("\n--- Liste des Dettes ---");
        detteRepository.getAllDettes().forEach(dette -> {
            System.out.println("ID Dette: " + dette.getId() + ", Date: " + dette.getDate() +
                               ", Montant: " + dette.getMontant() +
                               ", Montant Versé: " + dette.getMontantVerser() +
                               ", Montant Restant: " + dette.getMontantRestant() +
                               ", Client ID: " + dette.getClient().getId());
        });
    }
}
