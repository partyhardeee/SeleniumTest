import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefundTickerPriceTest {
    RefundCalculation refundCalculation = new RefundCalculation();


    @Test
    public void whenConcertIsCancelledExpected100() {
        Boolean wasConcertCancelled = true;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 0;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenConcertIsRescheduledExpected100() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = true;
        Integer hoursBeforeConcert = 0;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursOver240Expected100() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 241;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs240Expected50() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 240;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 50;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs121Expected50() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 121;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 50;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs120Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 120;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs119Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 119;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs73Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 73;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs72Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 72;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs71Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 71;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIs0Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 0;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIsNull() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = null;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void whenHoursIsMinus() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = -1;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }


}
