public interface OrderState {
    boolean request(Order order);
    boolean pay(Order order);
    boolean cancel(Order order);
    boolean send(Order order);
    boolean deliver(Order order);
    boolean giveBack(Order order);
    boolean finish(Order order);
    State getState();
}
