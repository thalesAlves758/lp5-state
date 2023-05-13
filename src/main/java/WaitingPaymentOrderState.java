public class WaitingPaymentOrderState implements OrderState {
    private static WaitingPaymentOrderState instance = null;
    public static WaitingPaymentOrderState getInstance() {
        if(instance == null) {
            instance = new WaitingPaymentOrderState();
        }
        return instance;
    }
    private WaitingPaymentOrderState() {}

    public boolean request(Order order) {
        return false;
    }

    public boolean pay(Order order) {
        order.setState(ProcessingOrderState.getInstance());
        return true;
    }

    public boolean cancel(Order order) {
        order.setState(CanceledOrderState.getInstance());
        return true;
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
        return State.WAITING_PAYMENT;
    }
}
