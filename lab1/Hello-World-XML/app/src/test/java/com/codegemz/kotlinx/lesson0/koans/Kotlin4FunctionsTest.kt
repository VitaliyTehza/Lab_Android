package com.codegemz.kotlinx.lesson0.koans

import org.junit.*
import org.junit.Assert.*

data class Account(val accountType : Int, val currencyType : Int, val initialValue: Long);

data class User(val name: String, val accounts : List<Account>)

class Kotlin4FunctionsTest {

    val accountTypes = HashMap<Int, String>().apply {
        put(0, "deposit")
        put(1, "saving")
        put(2, "kredit")
    }

    val currencyTypes = HashMap<Int, String>().apply {
        put(0, "USD")
        put(1, "EUR")
        put(2, "BITCOIN")
    }

    fun createBankAccout(userName: String, accountType : Int, currencyType : Int, initialValue: Long) : User {

        val account = Account(accountType, currencyType, initialValue)
        val user = User(userName, listOf(account))
        // do some banking

        return user

    }

    @Ignore
    @Test
    fun callFunctionInUsualWay() {

        // we can easilly type parameters in wrong order and break the logic
        val user = createBankAccout("John Smith", 1, 0, 0)

        assertEquals(FIX_ME, accountTypes[user.accounts[0].accountType])

        assertEquals(FIX_ME, currencyTypes[user.accounts[0].currencyType])
    }

    @Ignore
    @Test
    fun callFunctionWithNamedArguments() {

        // now we can use any order actually

        val user = createBankAccout(userName = "John Smith", initialValue = 0, accountType = 1, currencyType = 0)

        assertEquals(FIX_ME, accountTypes[user.accounts[0].accountType])

        assertEquals(FIX_ME, currencyTypes[user.accounts[0].currencyType])
    }

    fun Int.squared() = this * this

    @Ignore
    @Test
    fun extensionFunction() {

        // on java, you can only do something like squared(4);
        // in Kotlin, we define additional functions for any Class

        assertEquals(FIX_ME, 4.squared())
    }

    val Int.mysqr get() = this * this

    @Ignore
    @Test
    fun _04_extensionProperty() {

        // you can even define additional property on existing class!

        assertEquals(FIX_ME, 4.mysqr)
    }
}