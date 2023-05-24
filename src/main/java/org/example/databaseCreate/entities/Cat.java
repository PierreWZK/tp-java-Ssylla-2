package org.example.databaseCreate.entities;

import org.example.databaseCreate.entities.Animal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat")
public class Cat extends Animal {
    @Column(name = "chip_id")
    private String chipId;

    // Getters and setters

      public String getChipId() {
         return chipId;
      }

      public void setChipId(String chipId) {
         this.chipId = chipId;
      }

      @Override
      public String toString() {
         return "Cat{" +
                 "chipId='" + chipId + '\'' +
                 '}';
      }

      public Cat() {
      }
}
