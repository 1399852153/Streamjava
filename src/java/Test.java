import java.util.function.Predicate;

/**
 * @Author xiongyx
 * @Date 2019/3/4
 */
public class Test {

    public static void main(String[] args){
        Predicate<Integer> p = lazyTest( item->{
            System.out.println("item1");
            return true;
        },  item->{
            System.out.println("item2");
            return true;
        } );
        // false
        boolean b = p.test(-5);
        System.out.println(b);
    }

    public static Predicate<Integer> lazyTest(Predicate<Integer> p1, Predicate<Integer> p2) {
        System.out.println("???");
        return p1.and(p2);
    }
}
