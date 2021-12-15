import java.util.Random;

public class Producer extends Thread{
	private Buffer buffer;
	Random random = new Random();
	double total = 0;
	int count = 0;
	Double bufferElement;
	
	public Producer(Buffer b) {
		buffer = b;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			bufferElement = random.nextDouble() * 100.0;
			buffer.insert(bufferElement);
			total += bufferElement;
			count++;
			if(count%100000 == 0){
				System.out.printf("Producer: Generated %,d items, Cumulative value of generated items=%.3f\n", count, total);
			}
			if(count == 1000000){
				System.out.printf("Producer: Finished generating %,d items\n", count);
				break;
			}
		}
	}
}
