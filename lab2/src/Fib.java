public class Fib {
    public static int fibbI(int N){
        if (N < 1 ) return 0;
        int a=1,b=1,res = 1;
        for(int i=2;i<N;i++){
            res = a+b;
            a = b;
            b = res;
        }
    return res;
    }
    public static int fibbR(int N) {
        if ( N < 1) return 0;
        if (N == 1 || N == 2) return 1;
        else return fibbR(N-2) + fibbR(N-1);
    }

    public static void main(String[] args){
        System.out.println("Fib(18) = " + fibbI(18));
        System.out.println("Fib(18) = " + fibbR(18));

    }
}
