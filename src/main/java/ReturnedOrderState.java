public class ReturnedOrderState implements OrderState{
    private static ReturnedOrderState instance = null;
    public static ReturnedOrderState getInstance() {
        if(instance == null) {
            instance = new ReturnedOrderState();
        }
        return instance;
    }
    private ReturnedOrderState() {}

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
        return State.RETURNED;
    }
}
