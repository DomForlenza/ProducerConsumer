public class ProducerConsumer {

	public static void main(String[] args) {

		// Create buffer
		Buffer buf = new Buffer();

		// Create threads
		Thread producer = new Producer(buf);
		Thread consumer = new Consumer(buf);

		// Start threads
		producer.start();
		consumer.start();		
	}
}
