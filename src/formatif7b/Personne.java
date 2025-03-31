package formatif7b;

import java.text.Normalizer;

public class Personne {
    public static final String REGEX_DATE = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    public static final String REGEX_CODEPOSTAL = "^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$";
    public static final String REGEX_TELEPHONE = "[0-9][0-9][0-9][ ][0-9][0-9][0-9][ ][0-9][0-9][0-9][0-9]" + "|"
            + "[0-9][0-9][0-9][-][0-9][0-9][0-9][-][0-9][0-9][0-9][0-9]";
    public static final String PROVINCES_TERRITOIRES[] = {"QUEBEC", "ONTARIO", "MANITOBA", "SASKATCHEWAN", "ALBERTA",
            "COLOMBIE-BRITANNIQUE", "ILE-DU-PRINCE-EDOUARD", "NOUVEAU-BRUNSWICK", "NOUVELLE-ECOSSE",
            "TERRE-NEUVE-ET-LABRADOR", "TERRITOIRES DU NORD-OUEST", "NUNAVUT", "YUKON"};

    //Déclaration des constantes
    public static final String NOM_DEFAUT = "";
    public static final String PRENOM_DEFAUT = "";
    public static final int NOM_MAX = 100;
    public static final int PRENOM_MAX = 100;
    public static final int MAX_NO_CIVIQUE = 999999;
    public static final int MAX_RUE = 75;
    public static final int MAX_VILLE = 100;
    public static final String NO_CIVIQUE_DEFAUT = "1300";
    public static final String RUE_DEFAUT = "8e Avenue";
    public static final String VILLE_DEFAUT = "Québec";
    public static final String PROVINCE_DEFAUT = "Québec";
    public static final String CODE_POSTAL_DEFAUT = "G1J5L5";
    public static final String TELEPHONE_DEFAUT = "418-647-6600";

    //Déclaration des variables d'instance
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String noCivique;
    private String rue;
    private String ville;
    private String province;
    private String codePostal;
    private String telephone;

    public Personne() {
        nom = "";
        prenom = "";
        dateNaissance = "";
        noCivique = NO_CIVIQUE_DEFAUT;
        rue = RUE_DEFAUT;
        ville = VILLE_DEFAUT;
        province = PROVINCE_DEFAUT;
        codePostal = CODE_POSTAL_DEFAUT;
        telephone = TELEPHONE_DEFAUT;
    }

    public Personne(String nom, String prenom, String rue) {
        setNom(nom);
        setPrenom(prenom);
        setRue(rue);
        this.setCoordonnees(NO_CIVIQUE_DEFAUT, RUE_DEFAUT, VILLE_DEFAUT, PROVINCE_DEFAUT, CODE_POSTAL_DEFAUT, TELEPHONE_DEFAUT);
    }


    public Personne(String pNom, String pPrenom, String pDateNaissance, String pNoCivique, String pRue, String pVille,
                    String pProvince, String pCodePostal, String pTelephone) {
        this.nom = pNom;
        this.prenom = pPrenom;
        this.dateNaissance = pDateNaissance;
        this.setCoordonnees(pNoCivique, pRue, pVille, pProvince, pCodePostal, pTelephone);
    }

    public void setNom(String pNom) {
        assert validerChaine(pNom,2);
        nom = pNom;

    }

    public void setPrenom(String pPrenom) {
        if (validerChaine(pPrenom, PRENOM_MAX)) {
            prenom = pPrenom;
        } else {
            System.out.println("Le prénom est invalide.");
            prenom = PRENOM_DEFAUT;
        }
    }

    public void setDateNaissance(String pDate) {
        if (validerFormatDate(pDate)) {
            dateNaissance = pDate;
        } else {
            System.out.println("La date reçue est invalide. Le format doit être AAAA-MM-JJ");
        }
    }

    public void setCoordonnees(String pNoCivique, String pRue, String pVille,
                               String pProvince, String pCodePostal, String pTelephone) {
        setNoCivique(pNoCivique);
        setRue(pRue);
        setVille(pVille);
        setProvince(pProvince);
        setCodePostal(pCodePostal);
        setTelephone(pTelephone);
    }

    private void setNoCivique(String pNoCivique) {
        if (validerChaine(pNoCivique, MAX_NO_CIVIQUE)) {
            noCivique = pNoCivique;
        } else {
            System.out.println("Le numéro civique doit contenir entre 1 et " + MAX_NO_CIVIQUE + " caractères.");
        }
    }

    private void setRue(String pRue) {
        if (validerChaine(pRue, MAX_RUE)) {
            rue = pRue;
        } else {
            System.out.println("La rue doit contenir entre 1 et " + MAX_RUE + " caractères.");
        }
    }

    private void setVille(String pVille) {
        if (validerChaine(pVille, MAX_VILLE)) {
            ville = pVille;
        } else {
            System.out.println("La ville doit contenir entre 1 et " + MAX_VILLE + " caractères.");
        }
    }

    private void setProvince(String pProvince) {
        if (validerProvince(pProvince)) {
            pProvince = retirerAccents(pProvince);
            province = pProvince.toUpperCase();
        } else {
            System.out.println("La province reçue est invalide.");
        }
    }

    private void setCodePostal(String pCodePostal) {
        if (validerCodePostal(pCodePostal)) {
            codePostal = pCodePostal.toUpperCase();
            codePostal = codePostal.replaceAll(" ", "");
        } else {
            System.out.println("Le code postal reçu est invalide.");
        }
    }

    private void setTelephone(String pTelephone) {
        if (validerTelephone(pTelephone)) {
            telephone = pTelephone;
        } else {
            System.out.println("Le numéro de téléphone reçu est invalide. Les formats valides sont XXX-XXX-XXXX ou XXX XXX XXXX");
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getNoCivique() {
        return noCivique;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getProvince() {
        return province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getTelephone() {
        telephone = telephone.replaceAll("-", "");
        telephone = telephone.replaceAll(" ", "");
        telephone = "(" + telephone.substring(0, 3) + ") " + telephone.substring(3, 6) + "-" + telephone.substring(6);
        return telephone;
    }

    public String toString() {
        return "Nom, prénom: " + getNom() + ", " + getPrenom() + "\n" +
                "Date de naissance: " + getDateNaissance() + "\n" +
                "Adresse: " + getNoCivique() + ", " + getRue() + ", " + getVille() + " (" + getProvince() + ") " + getCodePostal() + "\n" +
                "Téléphone: " + getTelephone();
    }


    // --- Section Validations -------------------

    public static boolean validerProvince(String pProvince) {
        boolean estValide = false;
        int i = 0;
        if (pProvince != null) {
            pProvince = retirerAccents(pProvince);
            while (i < PROVINCES_TERRITOIRES.length && estValide == false) {
                if (pProvince.equalsIgnoreCase(PROVINCES_TERRITOIRES[i])) {
                    estValide = true;
                }
                i++;
            }
        }
        return estValide;
    }

    public static boolean validerCodePostal(String pCodePostal) {
        pCodePostal = pCodePostal.toUpperCase();
        return pCodePostal.matches(REGEX_CODEPOSTAL);
    }

    public static boolean validerTelephone(String pTelephone) {
        return pTelephone.matches(REGEX_TELEPHONE);
    }

    public static String retirerAccents(String pChaine) {
        pChaine = Normalizer.normalize(pChaine, Normalizer.Form.NFD);
        pChaine = pChaine.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return pChaine;
    }

    public static boolean validerChaine(String pChaine, int pMax) {
        return (pChaine != null && pChaine.length() > 0 && pChaine.length() <= pMax);
    }

    // ici on valide seulement le format en fonction d'une expression régulière
    public static boolean validerFormatDate(String pDate) {
        return pDate.matches(REGEX_DATE);
    }
}
