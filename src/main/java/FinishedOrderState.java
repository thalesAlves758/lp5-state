public class FinishedOrderState implements OrderState{
    private static FinishedOrderState instance = null;
    public static FinishedOrderState getInstance() {
        if(instance == null) {
            instance = new FinishedOrderState();
        }
        return instance;
    }
    private FinishedOrderState() {}

    public boolean request(Order order) {
        return false;
    }

    public boolean pay(Order order) {
        return false;
    }

    public boolean cancel(Order order) {
        return false;
    }

    public boolean send(Order order) {
        return false;
    }

    public boolean deliver(Order order) {
        return false;
    }

    public boolean giveBack(Order order) {
        return false;
    }

    public boolean finish(Order order) {
        return false;
    }

    public State getState() {
        return State.FINISHED;
    }
}
