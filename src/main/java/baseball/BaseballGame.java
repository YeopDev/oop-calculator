package baseball;

import java.util.Scanner;

public class BaseballGame {
    static int strike = 0;
    static int ball = 0;
    static boolean gameStartYN = true;


    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();

        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 시작합니다.");

        //게임 시작
       while(gameStartYN) {
           int[] computerNum = computer.randomNum();
           int[] playerNum = player.answer();

           //컴퓨터가 지정한 숫자 배열값과 플레이어가 지정한 숫자 배열값의 자릿수가 맞아야합니다.
           for(int i = 0; i < computerNum.length; i++){
               if(computerNum[i] == playerNum[i]){
                   strike++;
               }else{
                   ball++;
               }
           }

           System.out.println("스트라이크 갯수 총: "+strike+"번 , 볼 갯수 총: "+ball+"번 맞췄습니다.");
           System.out.println("다시 하시겠습니까? 재시작:Y / 종료:N");
           String str = sc.next();
           if(str.toUpperCase().equals("Y")){
               System.out.println("다시 시작합니다.");
           }else{
               System.out.println("게임을 종료 합니다.");
               gameStartYN = false;
               break;
           }
        }

    }

}
