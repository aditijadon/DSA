package recursion;

public class Atoi {
    private static int atoi(String input){
        String s = input.strip();
        char symbol = s.startsWith("-") ? '-' : '+';
        return 1;
    }

    public static void main(String[] args) {
        String input = " -12345";
        atoi(input);
    }
}
