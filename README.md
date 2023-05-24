# Pierre DOLIVET
# TP multi-couches

## TP Animalerie
Ce projet a pour objectif de mettre en pratique les concepts de mapping et de manipulation des entités JPA, ainsi que de renforcer la compréhension de la modélisation JPA, en particulier l'utilisation des relations d'héritage.

## Contexte
Nous travaillons sur la modélisation d'une animalerie. L'objectif est de créer un projet "multi-couches" avec une bonne isolation des packages et de mettre en place une base de données appelée "petstore".

## Travail à faire
* Projet: Créez un projet avec une architecture "multi-couches" en veillant à bien isoler les différentes parties du code dans des packages distincts.

* Base de données: Créez une base de données appelée "petstore". Configurez une nouvelle persistence-unit dans le fichier persistence.xml pour accéder à cette base de données. Assurez-vous de mettre en place la configuration nécessaire pour que l'application prenne le contrôle de la création du schéma de la base de données.

* Mapping: Mettez en place le mapping des entités JPA en utilisant les annotations appropriées. Vous devez créer les entités JPA conformément au diagramme de classes fourni, en mappant tous les champs de chaque classe avec les tables correspondantes dans la base de données. N'oubliez pas de mapper les types énumérés également. Utilisez les annotations relationnelles (@OneToMany, @ManyToMany et @ManyToOne) sur les entités concernées. Mettez également en place les annotations d'héritage en choisissant la stratégie "1 table par classe".

* Manipulation: Mettez en place une série d'instructions pour créer et effectuer des requêtes sur les éléments de la base de données. Insérez au moins trois enregistrements dans chacune des tables en utilisant EntityManager. Réalisez une requête qui permet d'extraire tous les animaux d'une animalerie donnée.
