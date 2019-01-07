package 线程创建;

public class Main {


    public static void main(String[] args){
//        System.out.println("主线程start");
//        // 直接通过Thread方式创建
//        MyThread thread = new MyThread();
//        thread.setName("线程1");
//        thread.start();
//
//        // 通过Runnable方式创建
//        MyRunnable runnable = new MyRunnable();
//        Thread thread1 = new Thread(runnable);
//        thread1.setName("线程2");
//        thread1.start();
//
//        System.out.println("主线程end");







        // 直接通过Thread来买票
        // 如果需要线程间共享数据，就要使用Runnable
//
//        TicketThread thread1 = new TicketThread();
//        thread1.setName("窗口1");
//        TicketThread thread2 = new TicketThread();
//        thread2.setName("窗口2");
//        TicketThread thread3 = new TicketThread();
//        thread3.setName("窗口3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();





        // 通过Runnable来卖票
        // 通过Runnable可以实现线程间数据的共享，共享完数据之后有些问题，重复打印了数据
        TicketRunnable runnable = new TicketRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.setName("窗口1");
        Thread thread2 = new Thread(runnable);
        thread2.setName("窗口2");
        Thread thread3 = new Thread(runnable);
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
