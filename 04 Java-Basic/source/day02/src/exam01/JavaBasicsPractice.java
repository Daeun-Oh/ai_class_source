package exam01;

public class JavaBasicsPractice {
    public static void main(String[] args) {
        //Q1();
        //Q2();
        //Q3();
        //Q4();
        Q5();
    }
    public static void Q1() {
        /**
         * 1번. 변수 두 개를 선언해서 20과 3.0을 대입하고 두 변수의 사칙연산 결과를 정수로 출력해 보시오
         */
        int num1 = 20;
        double num2 = 3.0;
        //int resultP = num1 + (int)num2; // ❌ 오답
        //int resultM = num1 - (int)num2;
        //int resultMul = num1 * (int)num2;
        //int resultD = num1 / (int)num2;
        int resultP = (int) (num1 + num2); // ✔️ 정답
        int resultM = (int) (num1 - num2);
        int resultMul = (int) (num1 * num2);
        int resultD = (int) (num1 / num2);
        System.out.printf("+: %d\n-: %d\n*: %d\n/: %d\n", resultP, resultM, resultMul, resultD);
    }
    public static void Q2() {
        /**
         * 2번. 학생 40명이 리조트에 수학여행을 갔습니다. 리조트로 수학여행을 갔습니다.
         * 리조트는 방이 10개 있고 방번호는 0~9번까지 있습니다.
         * 40명의 학생이 각각 번호표를 받아 한 방에 4명씩 배정하여 다음과 같이 출력하시오.
         * (예 : 학생1, 방번호 1번)
         */
        for (int i = 0; i < 40; i++) { // ⭕ 정답
            int j = i % 10;
            System.out.printf("학생%d, 방번호%d번\n", i + 1, j);
        }
    }
    public static void Q3() {
        /**
         * 3번. 5층 건물이 있습니다.
         * 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스클럽입니다.
         * 건물의 층을 누르면 그 층이 어떤 곳인지 알려주는 엘리베이터가 있을 때,
         * 이를 switch ~ case문으로 구현하시오. (5층인 경우 ‘5층 헬스클럽입니다.’)
         */
        int floor = 2;
        switch (floor) { // ⭕ 정답
            case 1:
                System.out.printf("%d층은 약국입니다.\n", floor);
                break;
            case 2:
                System.out.printf("%d층은 정형외과입니다.\n", floor);
                break;
            case 3:
                System.out.printf("%d층은 피부과입니다.\n", floor);
                break;
            case 4:
                System.out.printf("%d층은 치과입니다.\n", floor);
                break;
            case 5:
                System.out.printf("%d층은 헬스클럽입니다.\n", floor);
                break;
            default:
                System.out.printf("%d층은 존재하지 않습니다.\n", floor);
                break;
        }
    }
    public static void Q4() {
        /**
         * 4번. 구구단을 홀수 단만 출력하도록 프로그램을 만드시오.
         */
//        for (int i = 2; i <= 9; i++) {
//            if (i % 2 == 1) {
//                System.out.printf("-----%d단-----\n", i);
//                for (int j = 1; j <= 9; j++) {
//                    System.out.printf("%d x %d = %d\n", i, j, i * j);
//                }
//            }
//        }
        for (int i = 2; i <= 9; i++) {
            if (i % 2 == 0) continue;

            System.out.printf("-----%d단-----\n", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
        }
    }
    public static void Q5() {
        /**
         * 5번. 구구단을 단보다 곱하는 수가 크거나 같은 경우만 출력하는 프로그램을 만들어 보세요.
         */
//        for (int i = 2; i <= 9; i++) {
//            System.out.printf("-----%d단-----\n", i);
//            for (int j = 1; j <= 9; j++) {
//                if (i <= j)
//                    System.out.printf("%d x %d = %d\n", i, j, i*j);
//            }
//        }
        for (int i = 2; i <= 9; i++) {
            System.out.printf("-----%d단-----\n", i);
            for (int j = 1; j <= 9; j++) {
                if (i > j) continue;

                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }
        }
    }
}
