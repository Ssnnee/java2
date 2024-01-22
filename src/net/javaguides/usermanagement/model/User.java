// package net.javaguides.usermanagement.model;
//
// /**
//  * User.java
//  * This is a model class represents a User entity
//  * @author Ramesh Fadatare
//  *
//  */
// public class User {
// 	protected int id;
// 	protected String name;
// 	protected String email;
// 	protected String country;
//
// 	public User() {
// 	}
//
// 	public User(String name, String email, String country) {
// 		super();
// 		this.name = name;
// 		this.email = email;
// 		this.country = country;
// 	}
//
// 	public User(int id, String name, String email, String country) {
// 		super();
// 		this.id = id;
// 		this.name = name;
// 		this.email = email;
// 		this.country = country;
// 	}
//
// 	public int getId() {
// 		return id;
// 	}
// 	public void setId(int id) {
// 		this.id = id;
// 	}
// 	public String getName() {
// 		return name;
// 	}
// 	public void setName(String name) {
// 		this.name = name;
// 	}
// 	public String getEmail() {
// 		return email;
// 	}
// 	public void setEmail(String email) {
// 		this.email = email;
// 	}
// 	public String getCountry() {
// 		return country;
// 	}
// 	public void setCountry(String country) {
// 		this.country = country;
// 	}
// }

package net.javaguides.usermanagement.model;

/**
 * Facture.java
 * This is a model class representing a Facture entity
 * @author [Ton Nom]
 *
 */
public class Facture {
    protected int id;
    protected String reference;
    protected String designation;
    protected double prixUnitaire;
    protected int quantite;
    protected double prixHT;
    protected double remise;
    protected double prixTTC;

    public Facture() {
    }

    public Facture(String reference, String designation, double prixUnitaire, int quantite,
                   double prixHT, double remise, double prixTTC) {
        super();
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.prixHT = prixHT;
        this.remise = remise;
        this.prixTTC = prixTTC;
    }

    public Facture(int id, String reference, String designation, double prixUnitaire,
                   int quantite, double prixHT, double remise, double prixTTC) {
        super();
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.prixHT = prixHT;
        this.remise = remise;
        this.prixTTC = prixTTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public double getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(double prixTTC) {
        this.prixTTC = prixTTC;
    }
}

