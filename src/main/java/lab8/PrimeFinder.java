package lab8;

import java.util.ArrayList;

public class PrimeFinder {

    private Long lower;
    private Long upper;

    public PrimeFinder(Long lower, Long upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public ArrayList<Long> find(){
        ArrayList<Long> lista = new ArrayList<Long>();
        for (Long i = this.lower; i < this.upper+ 1  ; i++) {
            boolean flag = false;
            if (i > 1){
                for (Long j = 2L; j < i; j++) {
                    if ( i % j == 0 )  flag = true;
                }
                if (!flag) lista.add(i);
            }
        }
        return lista;

    }

    public Long getLower() {
        return lower;
    }

    public void setLower(Long lower) {
        this.lower = lower;
    }

    public Long getUpper() {
        return upper;
    }

    public void setUpper(Long upper) {
        this.upper = upper;
    }
}
