import java.util.HashMap;

public class HashMapTest  implements Runnable{
   HashMap<String,Integer> hm ;
   public  HashMapTest ( HashMap<String,Integer> hm )
   {
      this.hm = hm;
   }
    public void updateIncrement( HashMap<String,Integer> hm, String s)
    {
        hm.put(s,hm.get(s)+1) ;
    }

    public void updateDecrease( HashMap<String,Integer> hm, String s)
    {
        hm.put(s,hm.get(s)-1) ;
    }

    @Override
    public void run() {
        for ( int i = 65; i <91; i++ )
        {
            String str = (char)i + "";
            updateIncrement(hm,str);
            updateDecrease(hm,str);
        }
    }
}
