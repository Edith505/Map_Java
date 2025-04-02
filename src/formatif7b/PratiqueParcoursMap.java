package formatif7b;

import java.util.*;

public class PratiqueParcoursMap {


    /**
     * <font color="green">facile-moyen</font>
     * Affiche toutes les clés que contient la map reçue ne paramètre
     *
     * @param laMap contient les clé à afficher
     */
    public void afficheToutesCles(Map<String, String> laMap) {
        // TODO 13
        // L’ensemble setDeCles contient toutes les clés de la HashMap map.
        Set<String> setDeCles = laMap.keySet();
        Iterator<String> it = setDeCles.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = laMap.get(key);
            System.out.println(key + " : " + value);
        }

    }

    /**
     * <font color="green">facile-moyen</font>
     * Affiche toutes les valeurs que contient la map reçue ne paramètre
     *
     * @param laMap contient les valeurs à afficher
     */
    public void afficheToutesValeurs(Map<String, String> laMap) {
        // TODO 14
        // La collection valeurs contient toutes les valeurs de la HashMap map.
        Collection<String> valeurs = laMap.values();
        for (String valeur : valeurs) {
            System.out.println("Le : " + valeur);
        }
    }

    /**
     * <font color="green">facile-moyen</font>
     * Affiche toutes les entrées (clé-valeur) que contient la map reçue ne paramètre
     *
     * @param laMap contient les entrées à afficher
     */
    public void afficheToutesClesValeurs(Map<String, String> laMap) {
        // TODO 15


    }

    /**
     * <font color="orange">moyen</font>
     * Retire de la map reçue toutes les valeurs supérieures au seuil reçu en paramètre.
     *
     * @param map      contient les entrées à afficher
     * @param seuilMax la valeur la plus grande qui peut être gardée
     */
    public void retireValeursTropGrandes(Map<String, Double> map, double seuilMax) {
        // TODO 16


    }

    /**
     * <font color="orange">moyen</font>
     * Retourne une map reçue qui contient les valeur communes entre les 2 map reçues en paramètre.
     * On utilise alors les clés de la preimères map
     *
     * @param map1 première map
     * @param map2 la valeur la plus grande qui peut être gardée
     * @return une map contenant les valeurs communes au 2 maps . Les clés utilisées sont celles de la première map
     */
    public Map<String, Integer> gardeValeursCommunes(Map<String, Integer> map1, Map<String, Integer> map2) {
        // TODO 17


        return null;
    }

    /**
     * <font color="orange">moyen</font>
     * additionne les valeurs communes aux 2 map reçues (qui ont la même clé dans les 2 map)
     * et retourne une map de sommes.
     *
     * @param map1 la première map de valeur
     * @param map2 la seconde map de valeur
     * @return la map contenant la somme des valeurs qui ont la même clé dans les 2 maps.
     */
    public Map<String, Integer> additionneValeursCorrespondantes(Map<String, Integer> map1, Map<String, Integer> map2) {
        // TODO 18

        return null;
    }


    public static void main(String[] args) {

        // Essayez vos méthodes ici


    }
}
