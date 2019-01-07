package 线程join;

public class Main {

    public static void main(String[] args){
        System.out.println("主线程start");

        MyThread thread = new MyThread();
        thread.setName("线程1");
        thread.start();
        // join 让“主线程”等待“子线程”结束之后才能继续运行  不理解可以查看这里：http://wangkuiwu.github.io/2012/08/08/threads-basic/
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程end");
    }
}
