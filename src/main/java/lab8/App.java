package lab8;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PrimeFinder primeFinder = new PrimeFinder(1L,1000000000000L);
        ArrayList<Long> lista = primeFinder.find();
        for (Long i : lista){
            System.out.println(i);
        }
    }
}
