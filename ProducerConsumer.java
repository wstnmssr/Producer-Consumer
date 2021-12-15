
public class ProducerConsumer{
	public static void main(String args[]){
		Buffer buffer = new Buffer();
		Producer prod = new Producer(buffer);
		Consumer cons = new Consumer(buffer);
		prod.start();
		cons.start();
		try {
			prod.join();
			cons.interrupt();
		} catch (InterruptedException e) {}
		System.out.println("Exiting!");
	}
}
