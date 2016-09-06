public class Consumer extends Thread {

	/* PUBLIC VARIABLES */
	public Buffer buf;
	
	/* PRIVATE VARIABLES */
	private double count;
	private final int MAX_COUNT = 1000000;

	// Consumer constructor
	public Consumer(Buffer buffer) {
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
			// Consume element (store in double for running count)
			double consumed = buf.consume();
			// Running element consumed count
			add(consumed);
			
			// 100,000
			if (buf.getCountConsumer() == 100000) {
				System.out
						.println("Consumer: Consumed 100,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 200,000
			if (buf.getCountConsumer() == 200000) {
				System.out
						.println("Consumer: Consumed 200,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 300,000
			if (buf.getCountConsumer() == 300000) {
				System.out
						.println("Consumer: Consumed 300,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 400,000
			if (buf.getCountConsumer() == 400000) {
				System.out
						.println("Consumer: Consumed 400,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 500,000
			if (buf.getCountConsumer() == 500000) {
				System.out
						.println("Producer: Consumed 500,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 600,000
			if (buf.getCountConsumer() == 600000) {
				System.out
						.println("Consumer: Consumed 600,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 700,000
			if (buf.getCountConsumer() == 700000) {
				System.out
						.println("Consumer: Consumed 700,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 800,000
			if (buf.getCountConsumer() == 800000) {
				System.out
						.println("Consumer: Consumed 800,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// 900,000
			if (buf.getCountConsumer() == 900000) {
				System.out
						.println("Consumer: Consumed 900,000 items, Cumulative value of consumed items=" + this.count);
				resetCount();
			}
			// Finished consuming - 1,000,000
			if (buf.getCountConsumer() == MAX_COUNT) {
				System.out.println("Consumer: Finsihed consuming 1,000,000 items");
				buf.setBooleanCTrue();
				buf.printExit();
			}
		}
	}
}
