

import java.util.*;

public class Tour {
    static List<String> lista = new ArrayList<>();
    static Map<String,String> mapa= new HashMap<>();
    static Set<String> s = new HashSet<>();
    public static void panstwa_stolice() {

        mapa.put("Polska","Warszawa");
        mapa.put("Niemcy","Berlin");
        mapa.put("Czechy","Praga");
        mapa.put("Litwa","Wilno");
        mapa.put("Francja","Paryż");
        mapa.put("Włochy","Rzym");

        for(String key : mapa.keySet()) {
            System.out.println(key + " : " + mapa.get(key));
        }
        if (mapa.containsKey("Szwecja")) System.out.println("Kolekcja zawiera Szwecję");
        else System.out.println("Kolekcja nie zawiera Szwecji");

    }
    public static void miasta(){

        lista.add("Wilno");
        lista.add("Berlin");
        lista.add("Wilno");
        lista.add("Rzym");
        lista.add("Paryż");
        lista.add("Berlin");

        for(String s : lista){
            System.out.println(s);

        }
        if(lista.contains("Paryż")) System.out.println("Lista zawiera Paryż");
        else System.out.println("Lista nie zawiera Paryża");
    }
    public static void unikalne_miasta(){

        s.addAll(lista);
        for(String tmp: s) System.out.println(tmp);
        if (s.contains("Rzym")) System.out.println("Set zawiera Rzym");
        else System.out.println("Set nie zawiera Rzymu");
    }
    public static void main(String[] args) {
        System.out.println("-------------------");
        panstwa_stolice();
        System.out.println("-------------------");
        miasta();
        System.out.println("-------------------");
        unikalne_miasta();
        System.out.println("Mapa ma " + mapa.size() + " elementów");
        System.out.println("Lista ma " + lista.size() + " elementów");
        System.out.println("Set ma " + s.size() + " elementów");
    }
}