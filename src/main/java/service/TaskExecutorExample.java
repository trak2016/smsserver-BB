package service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;

public class TaskExecutorExample implements Lifecycle {

	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

	@Autowired
	SMSSenderRunnable smsSenderRunnable;

	@PostConstruct
	public void initIt() throws Exception {
		smsSenderRunnable = new SMSSenderRunnable();
		System.out.println("Init method after properties are set");
		threadPool.scheduleAtFixedRate(smsSenderRunnable, 7, 1, TimeUnit.SECONDS);
	}

	@PreDestroy
	public void cleanUp() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");

	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}