package rabbitCatch;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RabbitCatchGame {
    /**
     * 플레이어, 토끼가 있다.
     * 1. 플레이어와 토끼는 30 X 30 크기의 필드에서 랜덤한 x,y 좌표에서 시작한다.
     * 2. 플레이어는 한번에 최대 10칸을 (x:10, y:10) 위, 아래, 왼쪽, 오른쪽 으로 이동할 수 있다. (단, 한번에 입력할 수 있는 방향은 x:왼쪽,오른쪽, y:위,아래 으로 2의 값만 넣을 수 있다.)
     * 3. 토끼는 한번에 최대 5칸을 (x:5, y:5) 위, 아래, 왼쪽, 오른쪽 으로 이동할 수 있다.
     * 4. 한 턴에 한번씩 플레이어에게 이동할 위치를 물어본다. 예시: 10L,10B == 왼쪽으로 10칸,아래로 10칸 이동
     * 5. 토끼가 플레이어보다 먼저 움직인다. (랜덤으로 좌우 5칸 이내)
     * 6. 플레이어와 토끼의 위치가 같다면 게임이 종료된다.
     */

    private static Scanner sc = new Scanner(System.in);
    private static Random rd = new Random();

    public static void main(String[] args) {
        //String location = str.replaceAll("[^0-9]","");
        //게임시작
        System.out.println("게임을 시작합니다.(예시: x좌표: 10R,L y좌표: 10T,B) ");
        int[] startRabbit = randomLocation();
        System.out.println("토끼의 시작 위치는 [" + startRabbit[0] + "," + startRabbit[1]+ "] 입니다.");
        int[] startHuman = randomLocation();
        System.out.println("플레이어의 시작 위치는 [" + startHuman[0] + "," + startHuman[1]+ "] 입니다.");
        while(true){
            System.out.println(" 토끼가 랜덤한 x,y좌표로 먼저 움직입니다. ");
            int[] randRabbit = rabbit(startRabbit);
            System.out.println("토끼의 위치는 [" + randRabbit[0] + "," + randRabbit[1]+ "] 입니다.");
            System.out.println(" 플레이어가 움직입니다. ");
            int[] playerHuman = player(startHuman);
            System.out.println("플레이어의 위치는 [" + playerHuman[0] + "," + playerHuman[1]+ "] 입니다.");
            if(playerHuman[0] == randRabbit[0] && playerHuman[1] == randRabbit[1]){
                System.out.println(" 플레이어가 토끼를 잡았습니다. 게임종료");
                break;
            }
        }
    }

    /*시작 위치 생성*/
    public static int[] randomLocation(){
        int[] location = new int[2];
        location[0]= rd.nextInt(31);
        location[1]= rd.nextInt(31);
        return location;
    }

    public static int[] player(int[] filed){
        System.out.println("플레이어의 위치 [ " + filed[0] + "," + filed[1] + " ]");

        String str = sc.nextLine();
        String[] location = str.split("\\D+");
        int x = Integer.parseInt(location[0]);
        int y = Integer.parseInt(location[1]);
        String alp = str.replaceAll("[^a-zA-Z&&[LRTB]]","");
        String[] drc = alp.split("");

        if((x < 11 && x >= 0) || (y < 11 && y >= 0)){
            if(drc[0].toUpperCase().equals("R")){
                if((filed[0]+10) <= 30) filed[0] += x;
            }else if(drc[0].toUpperCase().equals("L")){
                if((filed[0]-10) >= 0) filed[0] -= x;
            }

            if(drc[1].toUpperCase().equals("T")){
                if((filed[1]+10) <= 30) filed[1] += y;
            }else if(drc[1].toUpperCase().equals("B")){
                if((filed[1]-10) >= 0) filed[1] -= y;
            }
        }

        return filed;
    }

    public static int[] rabbit(int[] filed){
        System.out.println("토끼의 위치 [ " + filed[0] + "," + filed[1] + " ]");

        if((filed[0]+5) <= 30 || (filed[0]-5) >= 0) filed[0] += rd.nextInt(11)-5;

        if((filed[1]+5) <= 30 || (filed[1]-5) >= 0) filed[1] += rd.nextInt(11)-5;

        return filed;
    }
}


