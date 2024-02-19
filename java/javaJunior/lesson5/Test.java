public class Test {

    public static void main(String[] args) {
        
        String s = "@cl1 ololo";
        char f ='@';

        String[] sA = s.split(" ");
        System.out.println(sA[0] + " " + sA[1]);

        System.out.println(s.charAt(0) == f);

        System.out.println(sA[0].substring(1));


    }

}
