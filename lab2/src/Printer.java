public class Printer {
    public static void print_even(int N){
        if (N < 0 ){
            System.out.println("Dla podanego N nie można wykonać metody");
            return;
        }
        for(int i = 0;i <= N; i+= 2){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args){
        System.out.println("Liczby parzyste od 0 do 12: ");
        print_even(12);

    }
}
