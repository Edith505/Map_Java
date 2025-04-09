package formatif7b;


import java.util.*;

public class PratiqueSupplementaireMap {

    private String string;


    //TODO extra 1 Programmer la méthode suivante

    /**
     * Crée une map contenant toutes les personnes du set Reçu. Le nom de la personne est la clé de la map
     *
     * @param personnes les personnes à mettre dans la map
     * @return la map de personnes
     */
    public Map<String, Personne> mapPersonneANom(Set<Personne> personnes) {
        Map<String, Personne> mapPersonne = new HashMap<>();
        for (Personne personne : personnes) {
            mapPersonne.put(personne.getNom(), personne);
        }
        return mapPersonne;
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
        String key;
        Map<String, Personne> retMap = new HashMap<>();

        for (Personne personne : personnes) {
            if (critere == Critere.NOM) {
                key = personne.getNom();
            } else if (critere == Critere.RUE) {
                key = personne.getRue();
            } else if (critere == Critere.PRENOM) {
                key = personne.getPrenom();
            } else {
                key = null;
            }

            if (key != null) {
                retMap.put(key, personne);
            }
        }
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
        Collection<Personne> mapPersonne = personnes.values();

        Iterator<Personne> iter = mapPersonne.iterator();
        while (iter.hasNext()) {
            Personne personne = iter.next();
            if (!personne.getRue().equalsIgnoreCase(rue)) {
                iter.remove();
            }
        }
    }

    //TODO extra 4 Programmer la méthode suivante

    /**
     * Reçoit une map et donne à chaque personne le prénoms qui est dans sa clé
     *
     * @param personnes
     */
    public void changePrenomFromMap(Map<String, Personne> personnes) {
        for (Map.Entry<String, Personne> personneEntry : personnes.entrySet()) {
            personneEntry.getValue().setNom(personneEntry.getKey());
        }
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
        Map<Character, Integer> retMap = new HashMap<>();
        Set<Character> caractere = convertToCharSet(phrase);
        for (char c : caractere) {
            int valeur = 1;
            if (retMap.containsKey(c)) {
                valeur += retMap.get(c);
            }
            retMap.put(c, valeur);
        }

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
