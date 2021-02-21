package com.example.assignment.Tamir.exception

import java.math.BigDecimal

class CardNumberAlreadyExistsException(cardNumber: String) : RuntimeException("Card number $cardNumber is already exists")
class CardNumberNotFoundByNumberException(cardNumber: String) : RuntimeException("No such $cardNumber card number")
class CardNumberNotFoundByIDException(id: Long) : RuntimeException("No such card number by $id")
class IncorrectPinCodeException : RuntimeException("Incorrect pin code")
class IncorrectWithdrawAmount(amount: BigDecimal) : RuntimeException("Please choose less withdraw amount than $amount")
class NegativeAmountException(amount: BigDecimal) : RuntimeException("Negative amount of cash or zero - $amount")
