package DP;

import java.util.List;

public class KeysKeyboard {
    public int minSteps1(int n) {
        TempNode1[] tempList = new TempNode1[n + 1];
        for (int i = 1; i <= n; i++) {
            tempList[i] = new TempNode1();
            int tempStep = i == 1 ? 0 : 1000;
            int tempPre = 0;
            int tempPaste = 0;
            for (int j = (i + 1) / 2; j < i; j++) {
                if (i == j * 2 && (tempList[j].step + 1) < tempStep) {
                    tempStep = tempList[j].step + 1;
                    tempPre = j;
                    tempPaste = j;
                }
                if ((j + tempList[j].paste) == i && (tempList[j].step + 1) < tempStep) {
                    tempStep = tempList[j].step + 1;
                    tempPre = j;
                    tempPaste = tempList[j].paste;
                }

            }
            tempList[i].step = tempStep;
            tempList[i].pre = tempPre;
            tempList[i].paste = tempPaste;
        }
        return tempList[n].step;

    }

    class TempNode1 {
        int step = 0;
        int pre = 0;
        int paste = 0;
    }

//    public int minSteps(int n){
//        if(n<1)
//            return n;
//        TempNode[] tempList = new TempNode[n + 1];
//        for(int i=1;i<=n;i++){
//            tempList[i] = new TempNode();
//            int tempStep = i == 1 ? 0 : 1000;
//            int tempPaste = 0;
//            for(int j=(i + 1) / 2; j < i; j++){
//                if(j*2==i&&(tempList[j].step+2)<tempStep){
//                    tempStep=tempList[j].step+2;
//                    tempPaste=j;
//                }
//                if((tempList[j].paste+j)==i && (tempList[j].step+1)<tempStep){
//                    tempStep=tempList[j].step+1;
//                    tempPaste=tempList[j].paste;
//                }
//            }
//            tempList[i].step=tempStep;
//            tempList[i].paste=tempPaste;
//        }
//        return tempList[n].step;
//
//    }

//    public Boolean judge(List<Integer> paste,int j, int i){
//        for(int index = 0;index<paste.size();index++){
//
//        }
//    }

    class TempNode{
        int step=0;
        List<Integer> paste;
    }



//    public static void main(String[] args) {
//        System.out.println(new KeysKeyboard().minSteps(5));
//    }


}
