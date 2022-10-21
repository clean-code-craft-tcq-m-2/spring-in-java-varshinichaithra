package statisticker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatsChecker {
	private float maxThreshold;
	private IAlerter[] alerters;

	public StatsChecker(float maxThreshold, IAlerter[] alerters) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
	}
	public void checkAndAlert(List<Float> numberList) {
		Collections.sort(numberList);
		float max = numberList.get(numberList.size()-1);
		if(max>maxThreshold) {
			EmailAlert emailAlert=(EmailAlert) alerters[0];
            emailAlert.emailSent=true;
            LEDAlert ledAlert=(LEDAlert)alerters[1];
            ledAlert.ledGlows=true;
		}
		
	}
}
