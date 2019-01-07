package 守护线程;

public class MyThread extends Thread {

    @Override
    public void run() {
        // 每隔500毫秒  打印一个数字，总共打印10个
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"打印："+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
