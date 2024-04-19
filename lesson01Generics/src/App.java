import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // using the same class but it is String and String
        Dictionary<String, String> engToVie = new Dictionary<String, String>("Hello", "Chào");
        String englishWord = engToVie.getKey();
        String vietnameseWord = engToVie.getValue();
        System.out.println(englishWord + ": " + vietnameseWord);
        // using the same class but it is Integer and String
        Dictionary<Integer, String> numToEng = new Dictionary<Integer, String>(1, "One");
        // this will get the number in Integer and convert it into String
        String numberNum = numToEng.getKey().toString();
        // here is the proof that it is a Integer number
        System.out.println("This is proof for the class datatype is Integer: " + numToEng.getKey().getClass());
        String stringNum = numToEng.getValue();
        System.out.println(numberNum + ": " + stringNum);
        // generics with extends
        Book<String, String, String> bookExtd = new Book<String, String, String>("null", "không có gì",
                "often use in CS");
        String english = bookExtd.getKey();
        String vietnamese = bookExtd.getValue();
        String quanity = bookExtd.getInfo();
        System.out.println(english + ": " + vietnamese + "\nContext: " + quanity);
        // The ArrayList is the implementation of Generics
        ArrayList<String> list = new ArrayList<String>();
        list.add("Codelearn.io");
        list.add("Google.com");
        list.add("Azure");
        list.add("GCF");
        System.out.println(App.getFirstElement(list));
        System.out.println(getFirstElement(list));
    }

    // The <E> is for ArrayList<E>, The E is for the return type, so they serve
    // different purpose
    public static <E> E getFirstElement(ArrayList<E> list) {
        if (list.isEmpty())
            return null;
        E first = list.get(0);
        return first;
    }
}
