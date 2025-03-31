package formatif7b.enginRecherche;

import formatif7b.Personne;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoteurListe {
    List<Personne> personnes = new ArrayList<>();

    public MoteurListe() {
        personnes.add(new Personne("nA", "A","1"));
        personnes.add(new Personne("nB", "B","2"));
        personnes.add(new Personne("nC", "C","3"));
        personnes.add(new Personne("nD", "D","4"));
        personnes.add(new Personne("nE", "E","5"));
        personnes.add(new Personne("nF", "F","6"));
        personnes.add(new Personne("nG", "G","7"));
        personnes.add(new Personne("nH", "H","8"));
    }

    public Personne getPersonneAvecNom(String nom) {
        Personne retPersonne = null;
        Iterator<Personne> iter = personnes.iterator();

        while (iter.hasNext()) {
            Personne personne = iter.next();
            if (personne.getNom().equals(nom)) {
                retPersonne = personne;
            }
        }
        return retPersonne;
    }

    public Personne getPersonneAvecNomPrenom(String nom, String Prenom) {
        Personne retPersonne = null;
        Iterator<Personne> iter = personnes.iterator();

        while (iter.hasNext()) {
            Personne personne = iter.next();
            if (personne.getNom().equals(nom)) {
                retPersonne = personne;
            }
        }
        return retPersonne;
    }

    public Personne getPersonneSurRue(String rue) {
        Personne retPersonne = null;
        Iterator<Personne> iter = personnes.iterator();

        while (iter.hasNext()) {
            Personne personne = iter.next();
            if (personne.getRue().equals(rue)) {
                retPersonne = personne;
            }
        }
        return retPersonne;
    }

    public static void main(String[] args) {

    }
}
