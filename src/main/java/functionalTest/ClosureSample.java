package functionalTest;

import java.util.function.Function;

public class ClosureSample {

    Function<Integer, Integer> add (final int x){
        return y-> x+y;
    }

    public static void main(String[] args) {
        ClosureSample closureSample = new ClosureSample();
        Function<Integer, Integer> add10 = closureSample.add(10);
        Function<Integer, Integer> add20 = closureSample.add(20);
        Function<Integer, Integer> add30 = closureSample.add(30);

        System.out.println(add10.apply(5));
        System.out.println(add20.apply(5));
        System.out.println(add30.apply(5));
    }
}
