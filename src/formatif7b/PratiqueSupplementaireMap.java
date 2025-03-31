package formatif7b;


import java.util.*;

public class PratiqueSupplementaireMap {

    private String string;


    //TODO extra 1 Programmer la méthode suivante
    /**
     *  Crée une map contenant toutes les personnes du set Reçu. Le nom de la personne est la clé de la map
     *
     * @param personnes les personnes à mettre dans la map
     * @return la map de personnes
     */
    public Map<String, Personne> mapPersonneANom(Set<Personne> personnes) {


        return null;
    }

    public enum Critere {NOM, PRENOM, RUE}
//TODO extra 2 Programmer la méthode suivante
    /**
     * Crée une map de personnes. La clé de la map est une string correspondant au critère (nom, prenom ou rue).
     *
     * @param personnes Les personnes à mettre dans la map
     * @param critere   Le critère pour la clé de la map
     * @return la map avec les personnes
     */
    public Map<String, Personne> mapPersonneACritere(Set<Personne> personnes, Critere critere) {
        Map<String, Personne> retMap = null;


        return retMap;
    }

    //TODO extra 3 Programmer la méthode suivante
    /**
     * Retire de la map toutes les personnes qui ne sont pas sur la rue reçue en paramètre
     *
     * @param personnes La map de personnes à filtrer
     * @param rue       Le nom de la rue sur laquelle on doit garder les personnes
     */
    public void filtreRue(Map<String, Personne> personnes, String rue) {



    }

    //TODO extra 4 Programmer la méthode suivante
    /**
     * Reçoit une map et donne à chaque personne le prénoms qui est dans sa clé
     *
     * @param personnes
     */
    public void changePrenomFromMap(Map<String, Personne> personnes) {



    }

    private Set<Character> convertToCharSet(String phrase) {
        HashSet<Character> retSet = new HashSet<>();

        for (char val : phrase.toCharArray()) {
            retSet.add(val);
        }
        return retSet;
    }

    //TODO extra 5 Programmer la méthode suivante
    /**
     * Retourne une map qui contient en clé les lettres trouvées dans la phrase et en valeur le nombre d'occurence de cette lettre
     *
     * @param phrase la phrase à analyser
     * @return le compte de toutes les lettres dans une map <lettre comtpe></lettre>
     */
    public Map<Character, Integer> compteToutesLettres(String phrase) {
        Map<Character, Integer> retMap =null;

        return retMap;
    }

    public static void main(String[] args) {
        PratiqueSupplementaireMap texteUtility = new PratiqueSupplementaireMap();
        texteUtility.mapPersonneANom(new HashSet<>(Arrays.asList(
                new Personne("Paradis", "Pierre", "Mont"),
                new Personne("Tremblay", "Marcel", "Mont"),
                new Personne("St-Pierre", "George", "Mont"))));

        texteUtility.mapPersonneACritere(new HashSet<Personne>(Arrays.asList(
                new Personne("Paradis", "Pierre", "Mont"),
                new Personne("Tremblay", "Marcel", "Grand"),
                new Personne("St-Pierre", "George", "Petit"))), Critere.PRENOM);

        Map<String, Personne> personnes = new HashMap<>();
        personnes.put("a", new Personne("Paradis", "Pierre", "Mont"));
        personnes.put("b", new Personne("Paradis", "Pierre", "Petit"));
        personnes.put("c", new Personne("Paradis", "Pierre", "Mont"));
        texteUtility.filtreRue(personnes, "Mont");

        Map<String, Personne> personnes2 = new HashMap<>();
        personnes2.put("Pierre", new Personne("Paradis", "Prenom", "Mont"));
        personnes2.put("Paul", new Personne("Paradis", "Prenom", "Petit"));
        personnes2.put("Luc", new Personne("Paradis", "Prenom", "Mont"));
        texteUtility.changePrenomFromMap(personnes2);

        texteUtility.compteToutesLettres("Je suis perplexe sur ce qui s'en vient!");

    }
}
