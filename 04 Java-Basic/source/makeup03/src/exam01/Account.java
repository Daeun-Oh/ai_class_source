package exam01;

public class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) { // 동기화 처리
        if (balance >= money) {
            // 동시성 문제를 명확하게 확인하기 위해 sleep 코드 추가
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            balance -= money;
        }
    }

    /*public void withdraw(int money) { // 동기화 처리
        synchronized (this) {
            if (balance >= money) {
                // 동시성 문제를 명확하게 확인하기 위해 sleep 코드 추가
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                balance -= money;
            }
        }
    }*/
}
