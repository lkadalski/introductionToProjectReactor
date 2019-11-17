package functionalTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class TestFunctional {
    public static void main(String[] args) {
        var list = Arrays.asList("Orange", "Hello", "Mother", "Something");

        var out = mapForEach(list, it -> it.length());

        Collections.sort(list, (String a, String b)->{
            return a.compareTo(b);
        });
        System.out.println(list);
        System.out.println(out);
    }


    static <T,S>ArrayList<S> mapForEach (List<T> arr , Function<T,S> fn){
        var newArray = new ArrayList<S>();
        arr.forEach(t-> newArray.add(fn.apply(t)));
        return newArray;
    }

}
