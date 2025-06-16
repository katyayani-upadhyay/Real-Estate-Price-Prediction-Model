public class Pattern {
    public static void Rec(int n){
        if(n==0){
            
            return;
        }
        System.out.println(n +" ");
        Rec(n-1);

    }
    public static void main(String[] args) {
        int n =10;
        Rec(n);

    }
    
}