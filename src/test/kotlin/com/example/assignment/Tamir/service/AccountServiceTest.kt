package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.dto.AccountDTO
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountServiceTest(
    @Autowired
    private val accountService: AccountService
) {

    @Test
    fun manageAccounts() {
        val account = accountService.createAccount(
            accountDTO = AccountDTO(
                id = 0,
                userName = "Jhon",
                cardNumber = "KZ2020",
                pinCode = "2020",
                balance = BigDecimal("2000")
            )
        )

        Assert.assertTrue(accountService.findAll().isNotEmpty())

        val newPinCode = "2021"
        val newAccount = accountService.changePinCode(
            cardNumber = account.cardNumber,
            pinCode = account.pinCode,
            newPinCode = newPinCode
        )

        Assert.assertTrue(
            accountService.getAccountByPinCode(
                cardNumber = newAccount.cardNumber,
                pinCode = newAccount.pinCode
            ).pinCode == newPinCode
        )
    }
}
