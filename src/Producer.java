import java.util.Random;

public class Producer extends Thread {
	
	/* PUBLIC VARIABLES */
	public Buffer buf;
	
	/* PRIVATE VARIABLES */
	private double count;
	private final int MAX_COUNT = 1000000;
	
	// Producer constructor
	public Producer(Buffer buffer) {
		this.buf = buffer;
		this.count = 0.0;
	}
	
	// Running add total
	public void add(double value) {
		synchronized (buf) {
			count += value;
		}
	}
	
	// Reset count variable
	public void resetCount() {
		this.count = 0.0;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			// Get random double and produce into buffer if thread is not interrupted (waiting)
			Random rand = new Random();
			Double bufElement = rand.nextDouble() * 100.0;
			// Produce element
			buf.produce(bufElement);
			// Running count of produced elements
			add(bufElement);
			
			// 100,000
			if (buf.getCountProducer() == 100000) {
				System.out.println(
						"Producer: Generated 100,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 200,000
			if (buf.getCountProducer() == 200000) {
				System.out.println(
						"Producer: Generated 200,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 300,000
			if (buf.getCountProducer() == 300000) {
				System.out.println(
						"Producer: Generated 300,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 400,000
			if (buf.getCountProducer() == 400000) {
				System.out.println(
						"Producer: Generated 400,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 500,000
			if (buf.getCountProducer() == 500000) {
				System.out.println(
						"Producer: Generated 500,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 600,000
			if (buf.getCountProducer() == 600000) {
				System.out.println(
						"Producer: Generated 600,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 700,000
			if (buf.getCountProducer() == 700000) {
				System.out.println(
						"Producer: Generated 700,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 800,000
			if (buf.getCountProducer() == 800000) {
				System.out.println(
						"Producer: Generated 800,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 900,000
			if (buf.getCountProducer() == 900000) {
				System.out.println(
						"Producer: Generated 900,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// Finished consuming - 1,000,000
			if (buf.getCountProducer() == MAX_COUNT) {
				System.out.println("Producer: Finsihed generating 1,000,000 items");
				buf.setBooleanPTrue();
				buf.printExit();
			}
		}
	}
}
