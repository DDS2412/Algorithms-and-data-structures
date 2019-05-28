package stepik.overview;

import java.io.*;

class Main {
  private static final int MOD = (int)(10);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8192);
        int n = Integer.parseInt(br.readLine());
        System.out.print(fibonacci(n)); 
    }

    private static int fibonacci(int n){
        int a = 0;
        int b = 1;
        for(int i =0; i < n; i++){
            int c = (a + b ) % MOD;
            a = b;
            b = c;
        }

        return a;
    }
}