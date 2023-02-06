import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefundTickerPriceTest {
    RefundCalculation refundCalculation = new RefundCalculation();


    @Test
    public void WhenConcertIsCancelledExpected100() {
        Boolean wasConcertCancelled = true;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 0;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenConcertIsRescheduledExpected100() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = true;
        Integer hoursBeforeConcert = 0;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursOver240Expected100() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 241;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs240Expected50() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 240;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 100;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs121Expected50() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 121;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 50;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs120Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 120;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs119Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 119;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs73Expected30() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 73;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 30;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs72Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 72;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs71Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 71;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIs0Expected0() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = 72;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIsNull() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = null;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }

    @Test
    public void WhenHoursIsMinus() {
        Boolean wasConcertCancelled = false;
        Boolean wasConcertRescheduled = false;
        Integer hoursBeforeConcert = -1;
        Integer refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Integer expectedValue = 0;
        Assertions.assertEquals(expectedValue, refund);
    }


}
