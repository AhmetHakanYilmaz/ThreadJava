import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[]args) throws InterruptedException {
        HashMap<String, Integer> hm = new HashMap<>();

        HashMapTest hmTest = new HashMapTest(hm);
        for ( int i = 65; i <91; i++ )
        {
            String added = (char)i + "";
            hm.put(added,0);
        }

        List<Thread> threads = new ArrayList<>();
        System.out.println("At First");
        for (String name: hm.keySet()) {
            String key = name.toString();
            String value = hm.get(name).toString();
            System.out.println(key + " " + value);
        }

        for( int i = 0; i < 100; i++)
        {
            Thread t = new Thread(hmTest);

            threads.add(t);

            t.start();
        }

        for( int i = 0; i < 100; i++)
        {
            threads.get(i).join();
        }

        System.out.println("\nAt Last");
        for (String name: hm.keySet()) {
            String key = name.toString();
            String value = hm.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}
