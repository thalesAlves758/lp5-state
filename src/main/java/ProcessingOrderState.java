public class ProcessingOrderState implements OrderState {
    private static ProcessingOrderState instance = null;
    public static ProcessingOrderState getInstance() {
        if(instance == null) {
            instance = new ProcessingOrderState();
        }
        return instance;
    }
    private ProcessingOrderState() {}

    public boolean request(Order order) {
        return false;
    }

    public boolean pay(Order order) {
        return false;
    }

    public boolean cancel(Order order) {
        order.setState(CanceledOrderState.getInstance());
        return true;
    }

    public boolean send(Order order) {
        order.setState(SentOrderState.getInstance());
        return true;
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
        return State.PROCESSING;
    }
}
