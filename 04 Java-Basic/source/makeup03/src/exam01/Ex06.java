package exam01;

public class Ex06 {
    public static void main(String[] args) {
        /**
         * join(): 해당 쓰레드의 수행이 끝날 때까지 다른 쓰레드는 대기 상태
         */

        ThreadEx06_1 th1 = new ThreadEx06_1();
        ThreadEx06_2 th2 = new ThreadEx06_2();
        th1.start();
        th2.start();

        try {
            // main 쓰레드는 th1, th2의 수행이 끝날 때까지 일시 정지 상태
            // 수행이 끝나면 재개
            th1.join();
            th2.join();
        } catch (InterruptedException e) {}

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {}
        }
    }
}

class ThreadEx06_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

class ThreadEx06_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("*");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}