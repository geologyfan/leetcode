package BinarySearch;

public class ArrangingCoins {
    public static void main(String[] args){

    }

    public int arrangeCoins(int n){
        if(n<2)
            return n;
        int i=1;
        int temp = (i*(i-1)/2) + (i*(i-1)%2);
        while (temp<n){
            i++;
        }
        if((i*(i-1)%2==0 && temp == n ))
            return i;
        return i-1;

    }
}
