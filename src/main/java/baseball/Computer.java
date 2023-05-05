package baseball;

import java.util.Random;

public class Computer {
    int[] randNum = new int[3];
    public int[] randomNum(){ //컴퓨터가 생각하는 숫자생성
        Random random = new Random();
        // 과정1 : 배열의 길이만큼 반복문을 돌려서 랜덤숫자를 뽑고, 중복이 있는지 확인
        for(int i = 0; i < randNum.length; i++) {
            randNum[i] = random.nextInt(9);// 랜덤숫자를 배열에 넣기
            for(int j = 0; j < i; j++) {
                // i인덱스에 들어갈 숫자를 반복문을통해 같은숫자가 있는지 확인
                if(randNum[j] == randNum[i]) {
                    //중복이 있으면 반복문을 빠져나가고 전 단계로 이동
                    i--;
                    break;
                }
            }
        }
        /*System.out.println("컴퓨터가 생각하는 숫자 ");
        for(int x : randNum) {
            //랜덤숫자 확인
            System.out.print(x + " ");
        }*/
        return randNum;
    }

}
