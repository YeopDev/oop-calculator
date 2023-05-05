package baseball;

import java.util.Scanner;

public class Player {
    int[] input = new int[3];

    //플레이어가 생각하는 숫자
    public int[] answer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자를 3개 입력해주세요.");
        for(int i = 0; i < input.length; i++){
            input[i] = scan.nextInt();
            if(input[i] > 9){
                System.out.println("1~9의 숫자만 입력하세요");
                i--;
            }
            for(int j = 0; j < i; j++) {
                if(input[j] == input[i]) {
                    System.out.println("다른 숫자를 입력하세요");
                    i--;
                    break;
                }
            }
        }
       // for(int key : input){System.out.print(key);}
        return input;
    }
}
