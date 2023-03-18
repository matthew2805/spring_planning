package tickets;

public class Ticket {
    protected final int id;
    protected final String name;
    protected final int estimate;
    protected boolean completeCheck;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completeCheck = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.completeCheck;
    }

    public void complete() {
        this.completeCheck = true;
    }

    public int getEstimate() {
        return this.estimate;
    }
}
