

public class Triangle {
    public static void print_triangle(int n) {
        if ( n < 1){
            System.out.println("Nie można wykonać metody dla podanego N");
            return;
        }
        int[][] tab = new int[n][n];
        for(int i=0;i<n;i++) {
            tab[i][0] = 1;
            for(int j=1;j<=i;j++) {
                tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (tab[i][j] == 0){System.out.print(" ");}
                else  System.out.print(tab[i][j]);


            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        print_triangle(-5);
    }
}
