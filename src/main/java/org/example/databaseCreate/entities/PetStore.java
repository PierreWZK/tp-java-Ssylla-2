package org.example.databaseCreate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    private List<Product> products;

    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals;

    @OneToOne(mappedBy = "petStore")
    private Address address;

    // ... autres attributs, constructeurs, getters et setters

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", animals=" + animals +
                ", address=" + address +
                '}';
    }

    public PetStore() {
    }

      public PetStore(String name, String managerName, List<Product> products, List<Animal> animals, Address address) {
         this.name = name;
         this.managerName = managerName;
         this.products = products;
         this.animals = animals;
         this.address = address;
      }

      public Long getId() {
         return id;
      }

      public void setId(Long id) {
         this.id = id;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public String getManagerName() {
         return managerName;
      }

      public void setManagerName(String managerName) {
         this.managerName = managerName;
      }

      public List<Product> getProducts() {
         return products;
      }

      public void setProducts(List<Product> products) {
         this.products = products;
      }

      public List<Animal> getAnimals() {
         return animals;
      }

      public void setAnimals(List<Animal> animals) {
         this.animals = animals;
      }

      public Address getAddress() {
         return address;
      }

      public void setAddress(Address address) {
         this.address = address;
      }

      public void addProduct(Product product) {
         this.products.add(product);
      }

      public void addAnimal(Animal animal) {
         this.animals.add(animal);
      }

      public void removeProduct(Product product) {
         this.products.remove(product);
      }

      public void removeAnimal(Animal animal) {
         this.animals.remove(animal);
      }

      public void removeAllProducts() {
         this.products.clear();
      }

      public void removeAllAnimals() {
         this.animals.clear();
      }

      public void removeAddress() {
         this.address = null;
      }

//      public getAnimals() {
//         return animals;
//      }
}
