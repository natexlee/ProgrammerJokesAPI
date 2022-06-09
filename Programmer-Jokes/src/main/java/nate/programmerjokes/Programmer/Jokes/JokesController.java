package nate.programmerjokes.Programmer.Jokes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController

public class JokesController {

	private static final String shower = "How did the programmer die in the shower?\n"
			+ "He read the shampoo bottle instructions: Lather. Rinse. Repeat."; 
	
	private static final String lightbulb = "How many programmers does it take to change a light bulb?\n"
			+ "None because it is a hardware problem";
	
	private static final String support = "Programming is like sex:  "
			+ "One mistake and you have to support it for the rest of your life.";
	
	private static final String warning = "A man is smoking a cigarette and blowing smoke rings into the air.  His girlfriend becomes irritated with the smoke and says... Can you see the warning on the cigarette pack?  Smoking is hazardous to your health"
			+ "      To which the man replies... I am a programmer.  We do not worry about warnings we only worry about errors.";
	
	private static final String debugging = "Debugging: Removing the needles from the haystack.";
	
	
	
	
	
	private static final String[] jokesArray = new String[] {shower, lightbulb, support, warning};
	
	static Random r = new Random();
	private static final int randIndex = r.nextInt(3-0) + 1;
	
	private final AtomicLong counter = new AtomicLong();
	
	//Entry point into the application
	@GetMapping("/randomjokes")
	public Jokes joke(@RequestParam(value = "name", defaultValue = "world") String name) {
		return new Jokes(counter.incrementAndGet(), String.format(jokesArray[randIndex], name));
	
	}
}
