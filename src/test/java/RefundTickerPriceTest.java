import org.junit.Assert;
import org.junit.Test;

public class RefundTickerPriceTest {
    RefundCalculation refundCalculation = new RefundCalculation();
    Boolean wasConcertCancelled;
    Boolean wasConcertRescheduled;
    Integer hoursBeforeConcert;
    Integer exprectedValue;
    Integer refund;

    @Test
    public void WhenConcertIsCanselledExpected100() {
        wasConcertCancelled = true;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 0;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 100;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenConcertIsRescheduledExpected100() {
        wasConcertCancelled = false;
        wasConcertRescheduled = true;
        hoursBeforeConcert = 0;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 100;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursOver240Expected100() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 241;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 100;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIs240Expected50() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 240;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 100;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIs144Expected50() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 144;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 50;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIs4Expected30() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 4;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 30;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIs3Expected0() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = 3;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 0;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIsNull() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = null;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 0;
        Assert.assertEquals(exprectedValue, refund);
    }

    @Test
    public void WhenHoursIsMinus() {
        wasConcertCancelled = false;
        wasConcertRescheduled = false;
        hoursBeforeConcert = -1;
        refund = refundCalculation.getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        exprectedValue = 0;
        Assert.assertEquals(exprectedValue, refund);
    }


}
