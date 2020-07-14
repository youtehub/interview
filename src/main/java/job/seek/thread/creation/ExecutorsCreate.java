package job.seek.thread.creation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Yiuahm
 */
public class ExecutorsCreate {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnableTest = new MyRunnable();
        FutureTask<Integer> myCallable = new FutureTask<>(new MyCallable());
        MyThread myThread = new MyThread();
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnableTest);
            executorService.execute(myThread);
            executorService.execute(myCallable);
        }

        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }

    @Test
    public void testFifo() {
        List list = new ArrayList<>();
        list.add(2);
        list.add(4345);
        list.add(4345L);
        list.add(4.36);
        list.add("3434");
        list.add("fgdgd");
        list.forEach(val -> System.out.print(val + ", "));
        Collections.reverse(list);
        System.out.println();
        list.forEach(val -> System.out.print(val + ", "));
    }
}

class MyRunnable01 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--Runnable--run()方法执行中...");
    }
}


class MyRunnable0133 extends AbstractQueuedSynchronizer {
    final void lock() {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
        } else {
            acquire(1);
        }
    }
}
