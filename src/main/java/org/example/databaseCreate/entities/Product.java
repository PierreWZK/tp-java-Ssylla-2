package org.example.databaseCreate.entities;
import org.example.databaseCreate.enums.ProdType;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Column(name = "type")
    private ProdType type;

    @Column(name = "price")
    private double prix;

    @ManyToOne
    private PetStore petStore;

    // ... autres attributs, constructeurs, getters et setters
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", prix=" + prix +
                ", petStore=" + petStore +
                '}';
    }

    public Product() {
    }

      public Product(String code, String label, ProdType type, double prix, PetStore petStore) {
         this.code = code;
         this.label = label;
         this.type = type;
         this.prix = prix;
         this.petStore = petStore;
      }

      public Long getId() {
         return id;
      }

      public void setId(Long id) {
         this.id = id;
      }

      public String getCode() {
         return code;
      }

      public void setCode(String code) {
         this.code = code;
      }

      public String getLabel() {
         return label;
      }

      public void setLabel(String label) {
         this.label = label;
      }

      public ProdType getType() {
         return type;
      }

      public void setType(ProdType type) {
         this.type = type;
      }

      public double getPrix() {
         return prix;
      }

      public void setPrix(double prix) {
         this.prix = prix;
      }

      public PetStore getPetStore() {
         return petStore;
      }

      public void setPetStore(PetStore petStore) {
         this.petStore = petStore;
      }
}
