public class Buffer{
	private final int maxSize;
	private int rear;
	private int front;
	private int numberOfElements;
	private double[] circularBuffer;
	
	public Buffer(){
		maxSize = 1001;
		front = rear = 0;
		numberOfElements = 0;
		circularBuffer = new double[maxSize];
	}
	
	public synchronized void insert(double d){
		try{
			while(numberOfElements == maxSize){
				wait();
			}
			circularBuffer[rear] = d;
			rear = (rear + 1) % maxSize; 
			numberOfElements++;
			notify();
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
	
	public synchronized double extract(){
		try{
			while(numberOfElements == 0){
			wait();
		}
		double retVal = circularBuffer[front];
		front = (front + 1) % maxSize;
		numberOfElements--;
		notify();
		return retVal;
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
			return 0;
		}
	}
}
