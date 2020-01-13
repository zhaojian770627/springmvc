package springmvc.web.controller;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class AsyncOrderController {

	@ResponseBody
	@RequestMapping("/createOrder")
	public DeferredResult<Object> createOrder() {
		DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 10000, "create fail...");
		ZJDeferredQueue.save(deferredResult);
		return deferredResult;
	}

	@ResponseBody
	@RequestMapping("/get")
	public String get() {
		String order = UUID.randomUUID().toString();
		DeferredResult<Object> deferredResult = ZJDeferredQueue.get();
		deferredResult.setResult(order);
		return "get method order=" + order;
	}

	@ResponseBody
	@RequestMapping("/asyncbuy")
	public Callable<String> asyncbuy() {
		System.out.println("主线程开始--" + Thread.currentThread() + "--" + System.currentTimeMillis());
		Callable<String> callable = new Callable<String>() {

			public String call() throws Exception {
				System.out.println("业务线程开始--" + Thread.currentThread() + "--" + System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(5);
				System.out.println("业务线程结束--" + Thread.currentThread() + "--" + System.currentTimeMillis());
				return "order by successful";
			}
		};
		System.out.println("主线程结束--" + Thread.currentThread() + "--" + System.currentTimeMillis());
		return callable;
	}

}
