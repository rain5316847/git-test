package com.example.workdaka;

import com.example.workdaka.service.IQRCodeService;
import com.example.workdaka.service.IUserService;
import com.example.workdaka.utils.R;
import com.example.workdaka.utils.ThreadPoolUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
class WorkDaKaApplicationTests {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IQRCodeService iqrCodeService;

//iqrCodeService.queryMsgWithoutQRCode("HTTP://AAX5.CN/B/HYL23EOPGEJ8K2ZZ061YV")
@Test
void all(){
    // System.out.println(iqrCodeService.queryMsgWithoutQRCode("HTTP://AAX5.CN/B/HYL23EOPGEJ8K2ZZ061YV"));
    ThreadPoolUtil.getInstance().poolExecutor.execute(()->{
        R r = iqrCodeService.queryMsgWithoutQRCode("HTTP://AAX5.CN/B/HYL23EOPGEJ8K2ZZ061YV");
        System.out.println("===========这次的结果是："+ r);
    });

}

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        FutureTask<R> futureTask = new FutureTask(new Task2());
        //自行运行得到结果
//        futureTask.run();

        //交给线程池管理运行
        cachedThreadPool.submit(futureTask);
        cachedThreadPool.shutdown();

        try {
            //get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回
            System.out.println("-------------task1返回结果 ： " + futureTask.get());
        } catch (Exception e) {
            System.out.println("-------------接收结果失败-------------");
            e.printStackTrace();
        }

        System.out.println("-------------task执行完成");
    }
}

class Task2 implements Callable<Integer> {

    @Autowired
    private IQRCodeService iqrCodeService;

    public Integer call() throws InterruptedException {
        R r = iqrCodeService.queryMsgWithoutQRCode("HTTP://AAX5.CN/B/HYL23EOPGEJ8K2ZZ061YV");
        System.out.println("----------子线程调度 : " + Thread.currentThread().getId());
        Thread.sleep(2000);
        return 1;
    }


}

class Test2{

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.TestOne("");
    }

    public void TestOne(String s){
        System.out.println(s.trim());
    }
}

