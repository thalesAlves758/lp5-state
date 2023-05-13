public class SentOrderState implements OrderState{
    private static SentOrderState instance = null;
    public static SentOrderState getInstance() {
        if(instance == null) {
            instance = new SentOrderState();
        }
        return instance;
    }
    private SentOrderState() {}

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
        order.setState(DeliveredOrderState.getInstance());
        return true;
    }

    public boolean giveBack(Order order) {
        return false;
    }

    public boolean finish(Order order) {
        return false;
    }

    public State getState() {
        return State.SENT;
    }
}
