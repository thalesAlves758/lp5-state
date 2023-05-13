public class Order {
    private OrderState state;

    public Order() {
        this.state = WaitingPaymentOrderState.getInstance();
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

    public State getState() {
        return this.state.getState();
    }

    public boolean request() {
        return state.request(this);
    }

    public boolean pay() {
        return state.pay(this);
    }

    public boolean cancel() {
        return state.cancel(this);
    }

    public boolean send() {
        return state.send(this);
    }

    public boolean deliver() {
        return state.deliver(this);
    }

    public boolean giveBack() {
        return state.giveBack(this);
    }

    public boolean finish() {
        return state.finish(this);
    }
}
