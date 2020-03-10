package contest.t0308;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/8
 */

public class Generate {
    public static void main(String[] args){

    }

    public String generateTheString(int n) {
        StringBuilder str = new StringBuilder(n);
        if(n<1){
            return str.toString();
        }

        if(n%2==1){
            for(int i=0;i<n;i++){
                str.append('a');
            }
        }else {
            for(int i=0;i<n-1;i++){
                str.append('a');
            }
            str.append('b');
        }
        return str.toString();
    }

}
