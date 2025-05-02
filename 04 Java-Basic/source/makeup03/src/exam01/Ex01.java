package exam01;

public class Ex01 {
    public static void main(String[] args) {

        ThreadEx01_1 th1 = new ThreadEx01_1();
        Thread th2 = new Thread(new ThreadEx01_2());
        Thread th3 = new Thread(() -> {
            Thread th = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                System.out.printf("num=%d, name=%s%n", i+1, th.getName());
                try {
                    Thread.sleep(1000); // 현재 실행 중인 Thread를 1초 간격으로 대기
                } catch (InterruptedException e) {}
            }
        });
        th1.start(); // Thread 실행 시작, 호출 스택 + run() 호출
        th2.start(); // Thread 실행 시작, 호출 스택 + run() 호출

        for (int i = 0; i < 10; i++) {
            // Thread.currentThread() : 현재 실행 중인 Thread
            Thread th = Thread.currentThread();
            System.out.printf("num=%d, name=%s%n", i + 1, th.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

class ThreadEx01_1 extends Thread {
    @Override
    public void run() { // Thread-1, getName()
        for (int i = 0; i < 5; i++) {
            System.out.printf("num=%d, name=%s%n", i+1, getName());
            try {
                Thread.sleep(1000); // 현재 실행 중인 Thread를 1초 간격으로 대기
            } catch (InterruptedException e) {}
        }
    }
}

class ThreadEx01_2 implements Runnable {
    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.printf("num=%d, name=%s%n", i+1, th.getName());
            try {
                Thread.sleep(1000); // 현재 실행 중인 Thread를 1초 간격으로 대기
            } catch (InterruptedException e) {}
        }
    }
}