# 📌 API DSS

![Java](https://img.shields.io/badge/Java-21-blue?style=flat&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=flat&logo=spring)  
![HTTPS](https://img.shields.io/badge/Security-HTTPS-blue?style=flat&logo=lock)  
![API](https://img.shields.io/badge/API-RESTful-lightgrey?style=flat)

Ce projet est une API REST développée avec **Spring Boot** et **Java 21**. Elle communique en **HTTPS**. Les données sont échangées au format **JSON**.

---

## 🏛️ Architecture

L'application suit une **architecture en 3 couches (Three-Tier Architecture)** basée sur le modèle **MVC** :

- **Controller** : Gère les requêtes HTTP et les envoie au service approprié.
- **Service** : Contient la logique métier.
- **Repository (DAO)** : Interagit avec la base de données via JPA/Hibernate.

### 📂 Structure du projet

```plaintext
src
 ├── main
 │   ├── java/com.example.dss
 │   │   ├── controller     # Gère les requêtes HTTP
 │   │   ├── dto            # Transfert de données (Data Transfer Objects)
 │   │   ├── model          # Modèles de données (JPA Entities)
 │   │   ├── mappers        # Transformation DTO <-> Entity
 │   │   ├── repository     # Accès aux données (JPA Repositories)
 │   │   ├── service        # Logique métier
 │   │   ├── utils          # Utilitaires divers
 │   │   ├── DssApplication.java # Point d'entrée de l'application
 │   ├── resources
 │   │   ├── application.properties # Configuration de l'application
 │   │   ├── application.yaml        # Alternative en YAML
 ├── target        # Dossier de build
 ├── pom.xml       # Fichier des dépendances
```
---

## 🚀 Pourquoi Java et Spring Boot ?

### **Java 21**
✅ **Portabilité** grâce à la JVM  
✅ **Programmation orientée objet**  
✅ **Outils de testing robustes**  
✅ **Écosystème et bibliothèques riches**

### **Spring Boot**
✅ **Serveur Web intégré** (Tomcat par défaut)  
✅ **Création facile de REST APIs** (`@RestController`, `@GetMapping`, `@PostMapping`, etc.)  
✅ **Gestion simplifiée des dépendances** (Maven / Gradle)  
✅ **Framework populaire en entreprise** avec **grande communauté** et **documentation abondante**

---'

## 📦 Dépendances utilisées

| 📦 Dépendance | 🔍 Rôle |
|--------------|--------|
| `spring-boot-starter-web` | Création d’API REST |
| `spring-boot-starter-data-jpa` | Gestion de la base de données avec JPA/Hibernate |
| `mysql-connector-j` | Driver JDBC pour MySQL |
| `lombok` | Réduction du boilerplate Java (Getters, Setters, etc.) |
| `mapstruct` | Mapping d'objets Java |
| `springdoc-openapi-starter-webmvc-ui` | Génération automatique de la documentation OpenAPI (Swagger UI) |
| `spring-boot-starter-validation` | Validation des données (annotations `@Valid`, etc.) |
| `spring-cloud-azure-starter-keyvault` | Intégration avec Azure Key Vault pour sécuriser les secrets |
| `spring-boot-devtools` | Outils de développement (reload à chaud) |


## Explication du Flow

1. Un Data scientist ajoute une image ainsi qu'une description dans la bd de décision temporaire
2. Un chief data scientist voit les décisions temporaire dans son interface
3. Le chief peut prendre une décision définitive avec d'autres équipe comme celle du marketing par exemple


