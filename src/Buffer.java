public class Buffer {
    
	/* PRIVATE VARIABLES */
	private int max_size; // Max size of buffer (will be 1000)
	private int front; // Front of buffer (circular)
	private int back; // Back of buffer (circular)
	private double[] buffer; // Buffer - implemented as a double array
	private int buffer_size; // Size of buffer (should go from 1000 to 0 and back)
	
	/* PUBLIC VARIABLES */
	public int countProducer; // Producer count to keep track of every 100k elements
	public int countConsumer; // Consumer count to keep track of every 100k elements
	public int element_count; // Element count for both consumer and producer totals
	public boolean finished_bool_p;
	public boolean finished_bool_c;
	
	public Buffer() {
		this.max_size = 1000; // Max buffer size set at 1000 (no more, no less)
		this.front = 0; // Front of buffer starts at 0
		this.back = 0; // Back of buffer starts at 0
		this.countProducer = 0; // Producer count begins at 0
		this.countConsumer = 0; // Consumer count begins at 0
		this.buffer_size = 0; // Set to 0 initially (nothing produced)
		this.finished_bool_c = false;
		this.finished_bool_p = false;
		this.buffer = new double[max_size]; // Set buffer size to max_size passed
	}
	
	// Getter to find buffer length
	public int getBufferSize() {
		return buffer.length; 
	}
	
	// Get running count - producer
	public int getCountProducer() {
		return countProducer;
	}
	
	// Get running count - consumer
	public int getCountConsumer() {
		return countConsumer;
	}

	// Set true when finished - Producer
	public void setBooleanPTrue() {
		this.finished_bool_p = true;
	}
	
	// Set true when finished - Consumer
	public void setBooleanCTrue() {
		this.finished_bool_c = true;
	}

	// Clear buffer of all elements (reset) -- Not sure if needed?
	public void clearBuffer() {
		this.front = 0;
		this.back = 0;
		this.buffer = new double[max_size];
	}
	
	// Check if buffer is empty
	public boolean bufferEmpty() {
		if (buffer_size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Check if buffer is full
	public boolean bufferFull() {
		if (buffer_size == max_size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Produce element
	public synchronized void produce(double back_element) {
		try {
			while (bufferFull()) {
				wait(); // wait if full! (can't produce any more)
			}
			back = (back + 1) % max_size; // algorithm from slides for FIFO circular producer
			buffer[back] = back_element;
			buffer_size++;
			countProducer++;
			notify(); // notify waiting consumer thread!
		} 
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}	
	}
	
	// Consume element
	public synchronized double consume() {
		try {
			while (bufferEmpty()) {
				wait(); // wait if empty! (nothing to consume)
			}
			double front_element = buffer[front];
			front = (front + 1) % max_size; // algorithm from slides for FIFO circular consumer
			buffer_size--;
			countConsumer++;
			notify(); // notify waiting producer thread!
			return front_element;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return -1;
		}	
	}
	
	// Print exit notice and exit program if both consumer and producer have finished
	public void printExit() {
		if (this.finished_bool_p == true && this.finished_bool_c == true) {
			System.out.println("Exiting!");
			System.exit(1);
		}
	}
}
