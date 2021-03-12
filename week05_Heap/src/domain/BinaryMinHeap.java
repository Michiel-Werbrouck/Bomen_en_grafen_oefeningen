package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");

        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = this.values.size() - 1; //start met laatste element
        while (heeftOuder(index) && ouder(index).compareTo(values.get(index)) > 0) {
            //ouder en kind staan in verkeerde volgorde, wissel ze om
            this.wisselOm(index, ouderIndex(index));
            index = ouderIndex(index);
        }
    }

    private boolean heeftOuder(int i) {
        return i >= 1;
    }

    private E ouder(int i) {
        return values.get(ouderIndex(i));
    }

    private int ouderIndex(int i) {
        return (i - 1) / 2;
    }

    private void wisselOm(int i, int j) {
        //wissel i-de en j-de element in de ArrayList om
        E hulp = this.values.get(i);
        this.values.set(i, this.values.get(j));
        this.values.set(j, hulp);
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        int index = 0; //start met de wortel
        boolean wisselOK = true;
        while (heeftLinkerKind(index) && wisselOK) {
            //welk kind is het kleinste?
            int indexKleinsteKind = indexLinkerKind(index);
            if (heeftRechterKind(index)
                    && values.get(indexKleinsteKind).compareTo(values.get(indexRechterKind(index))) > 0) {
                indexKleinsteKind = indexRechterKind(index);
            }
            //vergelijk ouderwaarde met waarde van kleinste kind
            if (values.get(index).compareTo(values.get(indexKleinsteKind)) > 0) {
                //foute volgorde, wissel om
                this.wisselOm(index, indexKleinsteKind);
            } else {
                //volgorde OK, while lus mag stoppen
                wisselOK = false;
            }
            //vertrek nu vanuit de index van het kleinste kind
            index = indexKleinsteKind;
        }
    }

    private int indexLinkerKind(int i) {
        return 2 * i + 1;
    }

    private int indexRechterKind(int i) {
        return 2 * i + 2;
    }

    private boolean heeftLinkerKind(int i) {
        return indexLinkerKind(i) < values.size();
    }

    private boolean heeftRechterKind(int i) {
        return indexRechterKind(i) < values.size();
    }

    public ArrayList<E> getPath(E value) {
        int index = this.values.indexOf(value);
        if (index == -1) {
            //value komt niet voor in de heap
            return null;
        } else {
            //value zit in heap, index = plaats van eerste voorkomen
            ArrayList<E> pad = new ArrayList<>();
            pad.add(value);
            while (index > 0) {
                //we zijn nog niet aan de wortel
                index = (index - 1) / 2; //ouder
                pad.add(0, this.values.get(index)); //voeg vooraan toe
            }
            return pad;
        }
    }
}
