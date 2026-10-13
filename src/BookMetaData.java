import java.util.LinkedList;
import java.util.Queue;

public class BookMetaData implements Suscribe {
    private String insNo;
    int availableCopies =0;
    int totalCopies = 0;
    private Queue<User>waitingQueue;


    public BookMetaData(String insNo) {
        this.insNo = insNo;
        availableCopies++;
        totalCopies++;
        waitingQueue=new LinkedList<>();
    }

    public String getInsNo() {
        return insNo;
    }

    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Queue<User> getWaitingQueue() {
        return waitingQueue;
    }

    public void setWaitingQueue(Queue<User> waitingQueue) {
        this.waitingQueue = waitingQueue;
    }

    @Override
    public void sendNotification(String message) {
        User user=waitingQueue.peek();
        user.notify(insNo+ " book is available in library");
    }
}
