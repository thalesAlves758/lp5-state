public class CanceledOrderState implements OrderState {
    private static CanceledOrderState instance = null;
    public static CanceledOrderState getInstance() {
        if(instance == null) {
            instance = new CanceledOrderState();
        }
        return instance;
    }
    private CanceledOrderState() {}

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
        return State.CANCELED;
    }
}
