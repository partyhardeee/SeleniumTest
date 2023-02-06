public class RefundCalculation {
    public Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }

}
