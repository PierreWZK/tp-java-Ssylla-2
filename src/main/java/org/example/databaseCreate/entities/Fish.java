package org.example.databaseCreate.entities;
import org.example.databaseCreate.entities.Animal;
import org.example.databaseCreate.enums.FishLivEnv;

import javax.persistence.*;

@Entity
@Table(name = "fish")
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    @Column(name = "living_env")
    private FishLivEnv livingEnv;

    // Getters and setters

      public FishLivEnv getLivingEnv() {
         return livingEnv;
      }

      public void setLivingEnv(FishLivEnv livingEnv) {
         this.livingEnv = livingEnv;
      }

      @Override
      public String toString() {
         return "Fish{" +
                 "livingEnv=" + livingEnv +
                 '}';
      }

      public Fish() {
      }
}