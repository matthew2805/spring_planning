

import tickets.UserStory;
import tickets.Ticket;
import tickets.Bug;
import java.util.Arrays;

public class Sprint {
    private final int capacity;
    private int counter = 0;
    private int currCapacity = 0;
    private final Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null) return false;
        if (userStory.getDependencies().length > 0) {
            int c = 0;
            for (int i = 0; i < userStory.getDependencies().length; i++) {
                for (Ticket ticket : tickets) {
                    if (userStory.getDependencies()[i].equals(ticket)) c++;
                }
            }
            if (c != userStory.getDependencies().length) return false;
        }
        return addObject(userStory);
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null) return false;
        return addObject(bugReport);
    }

    private boolean addObject(Ticket obj) {
        boolean flag;
        if (obj.isCompleted()) flag = false;
        else if (counter < this.tickets.length
                && obj.getEstimate() + this.currCapacity <= this.capacity) {
            tickets[counter] = obj;
            this.counter++;
            this.currCapacity += obj.getEstimate();
            flag = true;
        } else flag = false;
        return flag;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, counter);
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket val : Arrays.copyOf(tickets, counter)) {
            sum += val.getEstimate();
        }
        return sum;
    }
}
