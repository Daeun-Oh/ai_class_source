package exam01;

public class Ex07 {
    public static void main(String[] args) {
        Account sharedAccount = new Account(); // 하나의 계좌 공유

        ThreadEx07 th1 = new ThreadEx07(sharedAccount);
        ThreadEx07 th2 = new ThreadEx07(sharedAccount);

        th1.start();
        th2.start();
    }
}

class ThreadEx07 extends Thread {
    private Account account = new Account();    // volatile

    public ThreadEx07(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while(account.getBalance() > 0) {
            // 100, 200, 300
            int money = (int)(Math.random() * 3 + 1) * 100; // 100, 200, 300 중 랜덤 값
            account.withdraw(money);
            System.out.printf("잔액: %d%n", account.getBalance());
        }
    }
}