package src.main.java.com.gym17.gym17;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import src.main.java.com.gym17.gym17.model.LuckyReward;
import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.service.ActivityListService;
import src.main.java.com.gym17.gym17.service.CustomerMembershipFeeService;
import src.main.java.com.gym17.gym17.service.PrivateCoachService;
import src.main.java.com.gym17.gym17.service.LuckyRewardService;

import src.main.java.com.gym17.gym17.service.PrivateCoachWeekdaysService;
import src.main.java.com.gym17.gym17.service.ProductDiscountService;


@Configuration
@EnableScheduling
public class EventCreator {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	private PrivateCoachWeekdaysService PrivateCoachWeekdaysService;
	@Autowired
	private PrivateCoachService PrivateCoachService;
	@Autowired
	private LuckyRewardService LuckyRewardService;
	@Autowired
	private ActivityListService ActivityListService;
	@Autowired
	private CustomerMembershipFeeService CustomerMembershipFeeService;
	@Autowired
	private ProductDiscountService ProductDiscountService;
	
	@Scheduled(cron = "0 1 0 * * ?")
	public void reportCurrentTime() {
		ActivityListService.deleteOldEntety();
		ProductDiscountService.deleteOldEntety();
		CustomerMembershipFeeService.deleteOldEntety();
		
		Iterable<PrivateCoach> privateCoachs = PrivateCoachService.getOldEntety();
		PrivateCoachService.deleteOldEntety(privateCoachs);
		
		Iterable<LuckyReward> luckyReward = LuckyRewardService.getOldEntety();
		LuckyRewardService.deleteOldEntety(luckyReward);
	}
	

}
