package formatif7b;

import java.util.*;

public class PratiqueBasesMap {
    HashMap<String, String> map;

    /**
     * <font color="green">très facile</font>
     * Instancie l'attribut map de la classe
     */
    public PratiqueBasesMap() {
        // TODO 1
        map = new HashMap<>();
        remplir();
    }

    /**
     * <font color="green">très facile</font>
     * Ajoute 6 pairs (lettre, nombre) à votre choix .
     */
    private void remplir() {
        // TODO 2
        map.put("France", "Paris");
        map.put("Madagascar", "Tana");
        map.put("Canada", "Ottawa");
        map.put("Chine", "Hong Kong");
        map.put("Maurice", "Port Luis");
        map.put("Amerique", "New York");
    }

    /**
     * <font color="green">très facile</font>
     * Remplacez la valeur contenu dans la map par la valeur reçue uniquement si la clé est déjà dans la map
     */
    public void remplacer(String cle, String val) {
        // TODO 3
        map.replace(cle, val);
    }

    /**
     * <font color="green">très facile</font>
     * Ajoutez la valeur  dans la map uniquement si la clé n'est pas déjà dans la map.
     *
     * @return l'ancienne valeur si la clé n'est pas nouvelle
     */
    public String ajouteNouvelle(String cle, String nouvelleValeur) {
        // TODO 4
        return map.putIfAbsent(cle, nouvelleValeur);
    }

    @Override
    /**
     * <font color="green">très facile</font>
     * Affiche le contenu de l'attribut map.
     * @return la chaine de caractère
     */
    public String toString() {
        // TODO 5
        return map.toString();
    }

    /**
     * <font color="green">très facile</font>
     * Retrouve dans la map l'attribut associé à la clé reçue en paramètre
     *
     * @return la valeur associée à la clé
     */
    public String trouverValeur(String cle) {
        // TODO 6
        return map.get(cle);
    }

    /**
     * <font color="green">très facile</font>
     * Retire l'entrée de la map associée à la clé reçue
     *
     * @return la valeur retirée
     */
    public String supprimerCle(String cle) {
        // TODO 7
        // supprimer la valeur associé à la clé directement de la map
        // renvoie la valeur associé à la clé ou null si la clé est absente
        return map.remove(cle);
    }

    /**
     * <font color="green"> facile</font>
     * Retire la valeur de la map si elle s'y trouve. Pensez à récupérer la collection de valeurs.
     */
    public void supprimerValeur(String valeur) {
        // TODO 8
        Collection<String> value = map.values();
        value.remove(valeur);
    }

    /**
     * <font color="green">très  facile</font>
     * Ajoute tout le contenu de la map reçue en paramètre à l'attribut map.
     */
    public void ajouteTout(Map<String, String> nouvellesCles) {
        // TODO 9
        map.putAll(nouvellesCles);
    }


    /**
     * <font color="green">facile</font>
     * indique si la map contient toutes les clés reçues en paramètre
     *
     * @param keys l'enseble des clés souhaitées
     * @return vrai si toutes les clés sont dans la maps
     */
    public boolean contientToutesCles(Set<String> keys) {
        // TODO 10
        boolean contient = false;
        for (String key : keys) {
            if (map.containsKey(key)) {
                contient = true;
            }
        }
        return contient;
    }

    /**
     * <font color="green">facile-moyen</font>
     * ajoute le prefix reçu en paramtre à toutes les valeurs dont les clés sont
     * dans le paramètre clesAPrefixer et dans la map
     *
     * @param prefix        le prefix à ajouter au début de chaque valeur
     * @param clesAPrefixer les clés pour lesquelles il faut prefixer les valeurs.
     */
    public void ajoutePrefixAuxValeurs(String prefix, String... clesAPrefixer) {
        // TODO 11
        for (String cle : clesAPrefixer) {
            map.replace(cle, prefix + map.get(cle));
        }
    }


    /**
     * <font color="green">facile-moyen</font>
     * Retourne un set contenant toutes les valeurs qui sont dans la map et reçues en paramètre
     *
     * @param valeurs l'ensemble des valeurs à rechercher
     * @return l'ensemlbe des valeurs communes au paramètre et à la map
     */
    public Set<String> retrouveValeurCommune(String... valeurs) {
        // TODO 12
        Set<String> commune = new HashSet<>();
        for (String valeur : valeurs) {
            if (map.containsValue(valeur)) {
                commune.add(valeur);
            }
        }

        return commune;
    }

    /**
     * Premiers exercices à faire sur les map
     * <font color="green">facile</font>
     *
     * @param args
     */
    public static void main(String[] args) {
        //Utilisez et vérifiez toutes les méthodes que vous avez programmées.
        PratiqueBasesMap p = new PratiqueBasesMap();
        System.out.println("Map de base : " + p.map);
        p.remplacer("France", "Marseille");
        System.out.println("Remplacer : " + p.map);
        p.ajouteNouvelle("Bresil", "San Francisco");
        System.out.println("Ajouter : " + p.map);
        System.out.println("La valeur : " + p.trouverValeur("Canada"));
        p.supprimerCle("Canada");
        System.out.println("Supprimer clé : " + p.map);
        p.supprimerValeur("Port Luis");
        System.out.println("Supprimer valeurs : " + p.map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("Italie", "Rome");
        map2.put("Allemange", "Berlin");
        map2.put("Afrique du Sud", "Jouanesbourg");
        p.ajouteTout(map2);
        System.out.println("Map de base après ajout : " + p.map);
        Set<String> set = new HashSet<>();
        set.add("Madagascar");
        System.out.println("Si le set contient le cle : " + p.contientToutesCles(set));
        set.addAll(map2.keySet());
        System.out.println(p.retrouveValeurCommune(String.valueOf(set)));

    }
}


