public class Consumer extends Thread{
	private Buffer buffer;
	int count = 0;
	double total = 0;
	
	public Consumer(Buffer b){
		buffer = b;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			double d = buffer.extract();
			total += d;
			count++;
			if(count%100000 == 0){
				System.out.printf("Consumer: Consumed %,d items, Cumulative value of consumed items=%.3f\n", count, total);
			}
			if(count == 1000000){
				System.out.printf("Consumer: Finished consuming %,d items\n", count);
				break;
			}
		}
	}
}
