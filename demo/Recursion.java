public class Recursion {
     public static void main(String[] args) {
      int i,n=7;
      System.out.println("fibonacci series is:");
    for ( i = 0; i < n; i++) {
            System.out.print(fibonacci(i)+" ");
    }
}
 public static int fibonacci(int i){
        if(i==0 || i==1)
        return i;
        else
        return(fibonacci(i-1)+fibonacci(i-2));
 }
}