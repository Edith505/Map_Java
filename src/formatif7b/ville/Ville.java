package formatif7b.ville;

import java.util.*;

/**
 * <font color="red">Difficile</font>
 */
public class Ville {
    // Map<Integer, Maison> représente une rue avec des maison la clé est le numéro de porte
    //  Map<String, Map<Integer, Maison>> repésente un quartier avec des rues la clé est le nom de la rue
    private Map<String, Map<String, Map<Integer, Maison>>> ville;// représente une ville avec des quartiers. La clé est le nom du quartier

    //TODO 20 Gestion de ville
    /**
     * <font color="green">facile</font>
     */
    public void ajouteQuartier(String nomQuartier) {

    }

    //TODO 21 Gestion de ville
    /**
     * <font color="green">facile</font>
     */
    public void retireQuartier(String nomQuartier) {

    }

    //TODO 22 Gestion de quartier

    /**
     * <font color="orange">moyen</font>
     */
    public void ajouteRue(String nomQuartier, String nomRue) {

    }

    //TODO 23 Gestion de quartier
    /**
     * <font color="orange">moyen</font>
     */
    public boolean retireRue(String nomQuartier, String nomRue) {
        return false;
    }

    // TODO 24 Gestion de rue
    /**
     * <font color="red">Difficile</font>
     */
    public void ajouteMaison(String nomQuartier, String nomRue, int adresse, Maison nouvelleMaison) {

    }

    // TODO 25 Gestion de rue
    /**
     * <font color="red">moyen-Difficile</font>
     */
    public void retireMaison(String nomQuartier, String nomRue, int adresse) {

    }


    //TODO 26 Que vaut l'ensemble des maisons de la ville?
    /**
     * Calcule la valeur totale des toutes les maisons de la ville
     * <font color="red">moyen-difficile</font>
     *
     * @return la valeur totale des maisons de la ville
     */
    public double calculValeurMaisons() {
        int retVal = 0;


        return retVal;
    }

    //TODO 27 Que vaut les maisons dans les rues du questier.
    // On ne compte pas les rues qui ne sont pas dans le quartier fourni en paramètre.
    /**
     * Calcule la valeur totale des toutes les maisons qui sont dans les rues et les quartiers contenus
     * dans les paramètre nomsRue et nomsQuartier.
     * <font color="red">difficile</font>
     *
     * @return la valeur totale des maisons de la ville
     */
    public int calculValeurMaisonsDansRuesDansQuartiers(Set<String> nomsRue, Set<String> nomsQuartier) {
        int retVal = 0;


        return retVal;
    }

    // TODO 28 Retourne l'adresse de la maison recherchée en la fabriquant à partir des clé quartier, rue et nuero de porte
    /**
     * Trouve la maison demandée dans toute la ville
     * <font color="red">moyen-difficile</font>
     *
     * @return la valeur totale des maisons de la ville
     */
    public String trouveMaison(Maison maisonRecherchee) {
        String retVal = null;

        return retVal;
    }

    public static void main(String[] args) {

        //Le scénario suivant va vous aider à tester vos méthodes.

        Ville ville = new Ville();

        //On fabrique une ville avec 2 quartiers qui ont chaun 2 rues qui ont chacun 2 maisons
        ville.ajouteQuartier("Sainte-foy");

        ville.ajouteRue("Sainte-Foy", "Sapinière");
        ville.ajouteMaison("Sainte-Foy", "Sapinière", 157,
                new Maison("Pierre", "157 Sapinière", 200000));
        ville.ajouteMaison("Sainte-Foy", "Sapinière", 34,
                new Maison("Paul", "34 Sapinière", 300000));

        ville.ajouteRue("Sainte-Foy", "Des Sables");
        ville.ajouteMaison("Sainte-Foy", "Des Sables", 7,
                new Maison("Amelie", "7 Des Sables", 150000));
        ville.ajouteMaison("Sainte-Foy", "Des Sables", 65,
                new Maison("Lucie", "65 Des Sables", 220000));

        ville.ajouteQuartier("Québec");
        ville.ajouteRue("Québec", "Petit");
        ville.ajouteMaison("Québec", "Petit", 14,
                new Maison("ALbert", "14 Petit", 1780000));
        ville.ajouteMaison("Québec", "Petit", 75,
                new Maison("ALbert", "75 Petit", 324000));
        ville.ajouteRue("Québec", "Grand");
        ville.ajouteMaison("Québec", "Petit", 75,
                new Maison("ALbert", "75 Petit", 324000));

        double valeurToutesMaisons = ville.calculValeurMaisons();
        System.out.println("Cette ville vaut: " + valeurToutesMaisons);

        double ValeurCible = ville.calculValeurMaisonsDansRuesDansQuartiers(
                new HashSet<>(Arrays.asList("Sainte-Foy")),
                new HashSet<>(Arrays.asList("Petit", "Grand"))
        );

        String adresse = ville.trouveMaison(new Maison("Amelie", "7 Des Sables", 150000));
        System.out.println("L'adresse de Amélie est : " + adresse);


    }
}
