package org.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RockScissorsPaper {

	public static class PlayerCallable implements Callable {

		String name;

		int call_sequence = 0;

		static String[] SelectionTable = {
			"Rock", "Scissors", "Paper"
		};

		public PlayerCallable(String givenName) {
			this.name = givenName;
		}

		@Override
		public Object call() throws Exception {
			int delay = (int) (2000 * Math.random());
			call_sequence++;
			System.out.format("%s pauses %d microseconds on the %d-th invocation.\n", name, delay, call_sequence);
			Thread.sleep(delay);
			String choice = SelectionTable[(int) (Math.random()*3)];
			System.out.format("%s selects %s choice.\n", name, choice);
			return choice;
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService pool = Executors.newFixedThreadPool(2);
		PlayerCallable player1 = new PlayerCallable("player1");
		PlayerCallable player2 = new PlayerCallable("player2");
		for(int i=0; i<10; ++i) {
			Future<String> future1 = pool.submit(player1);
			Future<String> future2 = pool.submit(player2);
			System.out.println(payoff((String) future1.get(), (String) future2.get()));
		}
		pool.shutdown();
	}

	private static String payoff(String firstHand, String secondHand) {

		if(firstHand.equals(secondHand)) {
			return String.format("'%s' from both hands is a tie.\n", firstHand);
		}

		if(
				(firstHand.equals("Rock") && secondHand.equals("Scissors")) ||
				(firstHand.equals("Scissors") && secondHand.equals("Paper")) ||
				(firstHand.equals("Paper") && secondHand.equals("Rock"))
		) {
			return String.format("Player1's '%s' beats Player2's '%s'.\n", firstHand, secondHand);
		}

		return String.format("Player2's '%s' beats Player1's '%s'.\n", secondHand, firstHand);		
	}

}
