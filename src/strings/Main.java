package strings;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverseWithRecursion("hello"));
    }

    private static String reverseWithRecursion(String str) {
        if(str.equals("")){
            return "";
        }

        return reverseWithRecursion(str.substring(1))
                + str.charAt(0);
    }
}
