package 守护线程;

public class Main {

    public static void main(String[] args){
        // 用户线程  主线程执行结束 用户线程可以继续执行

        System.out.println("主线程start");

        MyThread thread = new MyThread();
        thread.setName("线程1");
        //设置为守护线程，必须在线程启动前设置
        //主线程结束后，守护线程就停止
        thread.setDaemon(true);
        thread.start();

        System.out.println("主线程end");
    }
}
