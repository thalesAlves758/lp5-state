public class DeliveredOrderState implements OrderState{
    private static DeliveredOrderState instance = null;
    public static DeliveredOrderState getInstance() {
        if(instance == null) {
            instance = new DeliveredOrderState();
        }
        return instance;
    }
    private DeliveredOrderState() {}

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
        order.setState(ReturnedOrderState.getInstance());
        return true;
    }

    public boolean finish(Order order) {
        order.setState(FinishedOrderState.getInstance());
        return true;
    }

    public State getState() {
        return State.DELIVERED;
    }
}
