package thread.ti;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated //太绕了, 没法理清思路
public class PrintOddEventByOrder_Condition {
    private Lock lock = new ReentrantLock();
    private Condition isOnesTurn = lock.newCondition();
    private Condition isTwosTurn = lock.newCondition();
    AtomicBoolean isOneRunAlready = new AtomicBoolean(false);


    public void work() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                lock.lock();
                try {
                    System.out.println("===> " + i);
                    isOneRunAlready.set(true);

                    System.out.println("AAAAAA");
                    isTwosTurn.signal();
                    System.out.println("BBBBBB");
                    isOnesTurn.await();
                    System.out.println("CCCCC");
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("0001");
            if (!isOneRunAlready.get()) {
                lock.lock();
                try {
                    System.out.println("002");
                    isTwosTurn.await();
                } catch (InterruptedException e) {
                } finally {
                    System.out.println("003");
                    lock.unlock();
                }
            }
            System.out.println("0004");

            for (int i = 2; i <= 10; i += 2) {
                lock.lock();
                try {
                    System.out.println("*** " + i);
                    isOnesTurn.signal();
                    isTwosTurn.await();
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintOddEventByOrder_Condition obj = new PrintOddEventByOrder_Condition();
        obj.work();
    }
}
