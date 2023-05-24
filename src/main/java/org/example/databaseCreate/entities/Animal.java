package org.example.databaseCreate.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth")
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    // ... autres attributs, constructeurs, getters et setters

      public Animal() {
      }

      public Animal(LocalDate dateNaissance, PetStore petStore) {
         this.dateNaissance = dateNaissance;
         this.petStore = petStore;
      }

      public Long getId() {
         return id;
      }

      public void setId(Long id) {
         this.id = id;
      }

      public LocalDate getDateNaissance() {
         return dateNaissance;
      }

      public void setDateNaissance(LocalDate dateNaissance) {
         this.dateNaissance = dateNaissance;
      }

      public PetStore getPetStore() {
         return petStore;
      }

      public void setPetStore(PetStore petStore) {
         this.petStore = petStore;
      }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", dateNaissance=" + dateNaissance +
                ", petStore=" + petStore +
                '}';
    }
}