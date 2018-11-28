package com.pl.web.task;

import com.pl.web.controller.bigdata.LabelComputerController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SpringJob {
	
	@Scheduled(cron="0 0 23 * * ?")
    public void run() {
		LabelComputerController labelComputerController = new LabelComputerController();
		labelComputerController.computeLabel();
    }
}
