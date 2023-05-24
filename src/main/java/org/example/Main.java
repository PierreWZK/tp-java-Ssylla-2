package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.example.databaseCreate.entities.*;
import org.example.databaseCreate.enums.FishLivEnv;
import org.example.databaseCreate.enums.ProdType;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tpPetStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Création d'une animalerie
            PetStore petStore = new PetStore();
            petStore.setName("Knowhere");
            petStore.setManagerName("Rocket Raccoon");

            // Création d'une deuxieme animalerie
            PetStore petStore2 = new PetStore();
            petStore2.setName("Smourbiff Shop");
            petStore2.setManagerName("Sparadrap");

            // Création d'une troisieme animalerie
            PetStore petStore3 = new PetStore();
            petStore3.setName("MagiChien");
            petStore3.setManagerName("Clifford le gros chien rouge");

            // Création de produits
            Product product1 = new Product("P001", "Croquettes", ProdType.FOOD, 10.99, petStore);
            Product product2 = new Product("P002", "Jouet", ProdType.ACCESSORY, 5.99, petStore2);
            Product product3 = new Product("P003", "Shampoing", ProdType.CLEANING, 8.99, petStore3);

            // Création d'animaux
            Animal animal1 = new Animal(LocalDate.of(2020, 1, 1), petStore);
            Animal animal2 = new Animal(LocalDate.of(2018, 5, 10), petStore2);
            Animal animal3 = new Animal(LocalDate.of(2019, 9, 15), petStore);

            // Création d'une adresse
            Address address = new Address();
            address.setNumber("10");
            address.setStreet("Rue du Néant");
            address.setZipCode("00001");
            address.setCity("Ville du Néant");
            address.setPetStore(petStore);

            // Création d'une deuxieme adresse
            Address address2 = new Address();
            address2.setNumber("1");
            address2.setStreet("Rue des Noobs");
            address2.setZipCode("66666");
            address2.setCity("Ville des Noobs");
            address2.setPetStore(petStore2);

            // Création d'une troisieme adresse
            Address address3 = new Address();
            address3.setNumber("5");
            address3.setStreet("Rue du parc animalier");
            address3.setZipCode("84312");
            address3.setCity("Ville Clifford");
            address3.setPetStore(petStore3);

            // Création d'un poisson
            Fish fish = new Fish();
            fish.setDateNaissance(LocalDate.of(1972, 3, 1));
            fish.setPetStore(petStore3);
            fish.setLivingEnv(FishLivEnv.SEA_WATER);

            // Création d'un deuxieme poisson
            Fish fish2 = new Fish();
            fish2.setDateNaissance(LocalDate.of(2021, 2, 8));
            fish2.setPetStore(petStore);
            fish2.setLivingEnv(FishLivEnv.FRESH_WATER);

            // Création d'un troisieme poisson
            Fish fish3 = new Fish();
            fish3.setDateNaissance(LocalDate.of(2005, 6, 24));
            fish3.setPetStore(petStore);
            fish3.setLivingEnv(FishLivEnv.SEA_WATER);

            // Création d'un chat
            Cat cat = new Cat();
            cat.setChipId("C001");
            cat.setDateNaissance(LocalDate.of(2015, 12, 25));
            cat.setPetStore(petStore2);

            // Création d'un deuxieme chat
            Cat cat2 = new Cat();
            cat2.setChipId("C002");
            cat2.setDateNaissance(LocalDate.of(2018, 8, 15));
            cat2.setPetStore(petStore3);

            // Création d'un troisieme chat
            Cat cat3 = new Cat();
            cat3.setChipId("C003");
            cat3.setDateNaissance(LocalDate.of(2019, 4, 30));
            cat3.setPetStore(petStore);

            // Enregistrement des entités
            entityManager.persist(petStore);
            entityManager.persist(petStore2);
            entityManager.persist(petStore3);
            entityManager.persist(product1);
            entityManager.persist(product2);
            entityManager.persist(product3);
            entityManager.persist(animal1);
            entityManager.persist(animal2);
            entityManager.persist(animal3);
            entityManager.persist(address);
            entityManager.persist(address2);
            entityManager.persist(address3);
            entityManager.persist(fish);
            entityManager.persist(fish2);
            entityManager.persist(fish3);
            entityManager.persist(cat);
            entityManager.persist(cat2);
            entityManager.persist(cat3);

            // Identifier l'animalerie pour laquelle on souhaite extraire les animaux
            Long petStoreId = 2L; // ID de l'animalerie (modifiable)

            // Requete pour afficher les animaux d'une animalerie
            System.out.println("Affichage des animaux d'une animalerie :");

            List<Animal> animals = entityManager.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :id", Animal.class)
                    .setParameter("id", petStoreId)
                    .getResultList();

            System.out.println("Petstore : " + animals.get(0).getPetStore().getName());

            for (Animal animal : animals) {
                // {type} née le {date de naissance}
                // Autres informations : {autres informations}
                // type = Cat, Fish, Dog (il faut split avec '{' et '}'
                System.out.println("");

                var typeAnimal = animal.toString().split("\\{")[0];
                var autreInfosAnimal = animal.toString().split("\\{")[1].split("\\}")[0];

                System.out.println(typeAnimal + " née le " + animal.getDateNaissance());
                System.out.println("Autres informations : " + autreInfosAnimal);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
