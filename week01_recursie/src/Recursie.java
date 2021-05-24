import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;

public class Recursie {

    // Oefening 1: n-de Fibonacci-getal
    public static int fibonacci(int getal) {
        if(getal <= 0)
            throw new IllegalArgumentException();
        if (getal <= 2)
            return 1;
        else
            return fibonacci(getal - 1) + fibonacci(getal - 2);
    }

    // Oefening 2 : som van cijfers
    public static int somVanCijfers(int getal) {
        String cijferStr = String.valueOf(getal);

        if (cijferStr.startsWith("-"))
            cijferStr = cijferStr.substring(1);

        if (cijferStr.length() == 1)
            return Integer.parseInt(cijferStr);

        int eersteCijfer = Integer.parseInt(String.valueOf(cijferStr.charAt(0)));

        return eersteCijfer + somVanCijfers(Integer.parseInt(cijferStr.substring(1)));
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) throw new IllegalArgumentException("Parameter mag niet null zijn.");
        if (s.isBlank() || s.length() == 1) return s;

        char lastChar = s.charAt(s.length() -1);

        return lastChar + keerOm(s.substring(0, s.indexOf(lastChar)));
    }

    //oefening 4: countX
    public static int countX(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.isBlank()) return 0;

        if (s.length() == 1) {
            if (s.equalsIgnoreCase("x")) return 1;
            return 0;
        } else {
            return (s.startsWith("x") ? 1 : 0) + countX(s.substring(1));
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return 0;
        if (s.length() == 2 && s.equalsIgnoreCase("hi")) return 1;

        return (s.startsWith("hi") ? 1 : 0) + countHi(s.substring(2));
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 1) {
            if (s.equalsIgnoreCase("x")) return "y";
            return s;
        }

        return (s.charAt(0) == 'x' ? 'y' : s.charAt(0)) + changeXY(s.substring(1));
    }

    // oefening 7
    public static String changePi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 2) {
            if (s.equalsIgnoreCase("pi")) return "3.14";
            return s;
        }

        return (s.startsWith("pi") ? "3.14" + changePi(s.substring(2)) : s.charAt(0) + changePi(s.substring(1)));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal < 1) throw new IllegalArgumentException();
        if (getal == 1) return 0;
        return (getal % 2 == 0 ? 1 : 0) + tweelog(getal / 2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null || lijst.size() == 0) throw new IllegalArgumentException();
        if (lijst.size() == 1) return lijst.get(0);
        if (lijst.get(0) < lijst.get(1)) {
            lijst.remove(0);
        } else {
            lijst.remove(1);
        }

        return findMaximum(lijst);
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string == null) throw new IllegalArgumentException();

        ArrayList<String> arrayList = new ArrayList<>();

        if (string.isBlank()) {
            arrayList.add("");
            return arrayList;
        }

        if(string.length() == 1) {
            arrayList.add(string);
            return arrayList;
        }

        arrayList.add(string.substring(0,1));

        for (String s : findSubstrings(string.substring(1))) {
            arrayList.add(string.charAt(0) + s);
        }

        arrayList.addAll(findSubstrings(string.substring(1)));
        return arrayList;
    }
}