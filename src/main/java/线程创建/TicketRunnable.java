package 线程创建;

/**
 * 线程安全问题出现的原因：
 * 是否是多线程  是
 * 是否有共享数据  是
 * 是否有多条语句操作共享数据    是 循环中多处曹组偶练ticket
 * <p>
 * 解决方案：同步
 */
public class TicketRunnable implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            // 加上同步锁
            synchronized (TicketRunnable.class) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出第" + ticket + "张票");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }
    }
}
