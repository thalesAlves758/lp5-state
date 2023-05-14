import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    void shouldNotChangeOrderStateToWaitingPaymentAgain() {
        Order order = new Order();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.WAITING_PAYMENT, order.getState());
    }

    @Test
    void shouldChangeStateFromWaitingPaymentToProcessing() {
        Order order = new Order();
        boolean result = order.pay();

        assertEquals(true, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldNotChangeOrderStateToProcessingAgain() {
        Order order = new Order();
        order.pay();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldNotChangeStateFromProcessingToWaitingPayment() {
        Order order = new Order();
        order.pay();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldChangeStateFromProcessingToSent() {
        Order order = new Order();
        order.pay();
        boolean result = order.send();

        assertEquals(true, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToSentAgain() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToWaitingPayment() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToProcessing() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToCanceled() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.cancel();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldChangeStateFromSentToDelivered() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.deliver();

        assertEquals(true, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromDeliveredToDeliveredAgain() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromDeliveredToWaitingPayment() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromDeliveredToProcessing() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromDeliveredToCanceled() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.cancel();

        assertEquals(false, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromDeliveredToSent() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.DELIVERED, order.getState());
    }

    @Test
    void shouldChangeStateFromDeliveredToReturned() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.giveBack();

        assertEquals(true, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToReturnedAgain() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToWaitingPayment() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToProcessing() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToCanceled() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.cancel();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToSent() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToDelivered() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromReturnedToFinished() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.giveBack();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.RETURNED, order.getState());
    }

    @Test
    void shouldChangeStateFromDeliveredToFinished() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        boolean result = order.finish();

        assertEquals(true, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToFinishedAgain() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToWaitingPayment() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToProcessing() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToCancel() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.cancel();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToSent() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToDelivered() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromFinishedToReturned() {
        Order order = new Order();
        order.pay();
        order.send();
        order.deliver();
        order.finish();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.FINISHED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToReturned() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromSentToFinished() {
        Order order = new Order();
        order.pay();
        order.send();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.SENT, order.getState());
    }

    @Test
    void shouldChangeStateFromProcessingToCanceled() {
        Order order = new Order();
        order.pay();
        boolean result = order.cancel();

        assertEquals(true, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromProcessingToDelivered() {
        Order order = new Order();
        order.pay();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldNotChangeStateFromProcessingToReturned() {
        Order order = new Order();
        order.pay();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldNotChangeStateFromProcessingToFinished() {
        Order order = new Order();
        order.pay();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.PROCESSING, order.getState());
    }

    @Test
    void shouldChangeStateFromWaitingPaymentToCanceled() {
        Order order = new Order();
        boolean result = order.cancel();

        assertEquals(true, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToWaitingPayment() {
        Order order = new Order();
        order.cancel();
        boolean result = order.request();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToCanceledAgain() {
        Order order = new Order();
        order.cancel();
        boolean result = order.cancel();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToProcessing() {
        Order order = new Order();
        order.cancel();
        boolean result = order.pay();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToSent() {
        Order order = new Order();
        order.cancel();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToDelivered() {
        Order order = new Order();
        order.cancel();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToReturned() {
        Order order = new Order();
        order.cancel();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromCanceledToFinished() {
        Order order = new Order();
        order.cancel();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.CANCELED, order.getState());
    }

    @Test
    void shouldNotChangeStateFromWaitingPaymentToSent() {
        Order order = new Order();
        boolean result = order.send();

        assertEquals(false, result);
        assertEquals(State.WAITING_PAYMENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromWaitingPaymentToDelivered() {
        Order order = new Order();
        boolean result = order.deliver();

        assertEquals(false, result);
        assertEquals(State.WAITING_PAYMENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromWaitingPaymentToReturned() {
        Order order = new Order();
        boolean result = order.giveBack();

        assertEquals(false, result);
        assertEquals(State.WAITING_PAYMENT, order.getState());
    }

    @Test
    void shouldNotChangeStateFromWaitingPaymentToFinished() {
        Order order = new Order();
        boolean result = order.finish();

        assertEquals(false, result);
        assertEquals(State.WAITING_PAYMENT, order.getState());
    }
}
