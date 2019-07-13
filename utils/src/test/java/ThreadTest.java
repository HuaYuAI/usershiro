import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huayu on 2019/5/25.
 */
public class ThreadTest implements Runnable{
    public static void main(String[] args) {
        // 伸缩性，每60秒回收一次
        ExecutorService service1 = Executors.newCachedThreadPool();
        // 固定线程数
        ExecutorService service2 = Executors.newFixedThreadPool(3);
        // 定时任务
        ExecutorService service3 = Executors.newScheduledThreadPool(3);
        // fork/join线程池
        ExecutorService service4 = Executors.newWorkStealingPool(3);
        // 只有一个核心线程的线程池
        ExecutorService service5 = Executors.newSingleThreadExecutor();

    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
