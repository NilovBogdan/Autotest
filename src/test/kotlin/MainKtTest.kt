import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTransferMir() {
        val cardType = "Mir"
        val transferSumMonth = 0
        val nextTransfer = 10000
        val different = 0
        var result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals("Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.", result)
    }
    @Test
    fun calculateTransferMastercardNotDifferent() {
        val cardType = "Mastercard"
        val transferSumMonth = 0
        val nextTransfer = 10000
        val different = 0
        var result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals("Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.", result)
    }
    @Test
    fun calculateTransferMastercardDifferent() {
        val cardType = "Mastercard"
        val transferSumMonth = 10000
        val nextTransfer = 80000
        val different = 11
        var result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals("Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.", result)
    }
    @Test
    fun calculateTransferCardtypeMastercardLimitTransferSumMonth() {
        val cardType = "Mastercard"
        val transferSumMonth = 80000
        val nextTransfer = 10000
        val different = 80
        val result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals(
            "Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.",
            result
        )
    }
    @Test
    fun calculateTransferCardtypeVisaNotDifferent() {
        val cardType = "Visa"
        val transferSumMonth = 0
        val nextTransfer = 10000
        val different = 75
        val result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals(
            "Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.",
            result
        )
    }
    @Test
    fun calculateTransferCardtypeVisaDifferent35() {
        val cardType = "Visa"
        val transferSumMonth = 0
        val nextTransfer = 100
        val different = 35
        val result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals(
            "Перевод на сумму " + nextTransfer + " руб. выполнен, комиссия составляет " + different + " руб.",
            result
        )
    }
    @Test
    fun calculateTransferExceededLimitDay() {
        val cardType = "Mastercard"
        val transferSumMonth = 75000
        val nextTransfer = 200000
        val different = 80
        val result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals(" Перевод не может быть выполнен, превышен лимит!", result)
    }
    @Test
    fun calculateTransferExceededLimitMonth() {
        val cardType = "Visa"
        val transferSumMonth = 500000
        val nextTransfer = 200000
        val different = 80
        val result = calculateTransfer(cardType, transferSumMonth, nextTransfer)
        assertEquals(" Перевод не может быть выполнен, превышен лимит!", result)
    }
}