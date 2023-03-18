package tickets;

public class UserStory extends Ticket {
    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependencies = dependsOn;
    }

    @Override
    public void complete() {
        if (this.dependencies.length > 0)
            this.completeCheck = dependenciesCompleteCheck();
        else this.completeCheck = true;
    }

    public UserStory[] getDependencies() {
        return this.dependencies.clone();
    }

    private boolean dependenciesCompleteCheck() {
        int len = this.dependencies.length;
        int a = 0;
        while (a < len && this.dependencies[a].completeCheck) {
            a++;
        }
        return a == len;
    }

    @Override
    public String toString() {
        return String.format("[US %d] %s", this.id, this.name);
    }

}
