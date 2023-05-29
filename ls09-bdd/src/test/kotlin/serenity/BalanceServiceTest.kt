package serenity

import BalanceService
import net.serenitybdd.junit.runners.SerenityRunner
import net.serenitybdd.junit5.SerenityJUnit5Extension
import net.thucydides.core.annotations.Step
import net.thucydides.core.annotations.Steps
import net.thucydides.core.annotations.Title
import net.thucydides.core.steps.ScenarioSteps
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import kotlin.test.assertEquals

//@RunWith(SerenityRunner::class)
//class BalanceServiceTest {
//
//    @Steps
//    lateinit var client: BalanceServiceSteps
//
//    @Test
//    @Title("Test to check adding money")
//    fun addingMoneyTest() {
//        client.addMoneyToBalance(200)
//        val count = client.getBalanceCount()
//        client.checkBalance(200, count)
//    }
//}
/**
 * Serenity заточен под организацию и использование шагов
 * аннотации по принципу похожи на Allure
 * подтянул еще другой проект:
 * serenity-junit-screenplay-starter
 * https://github.com/serenity-bdd/serenity-junit-starter.git
 * Это публичный Template - создавать на его основе свое
 */

//@RunWith(SerenityRunner::class)
@ExtendWith(SerenityJUnit5Extension::class)
class BalanceServiceTest {

    @Steps
    //lateinit var steps: BalanceServiceSteps
    lateinit var client: BalanceServiceSteps

    @Test
    // thucydides == serenity аннотации - много повышают читаемость
    @Title("Test to check adding money")
    fun addMoneyToBalance() {
        //var balanceService = BalanceService()
        //balanceService.addMoney(20)
        //steps.addMoneyToBalance(200)
       // assertEquals(20, balanceService.getBalance())
        //steps.checkBalance(200)

        client.addMoneyToBalance(200)
        client.checkBalance(200)
    }
}

open class BalanceServiceSteps: ScenarioSteps() {

    private val balanceService = BalanceService()

   // вместо {0} serenity подставит count
    @Step ("#actor Client add {0} amount of money balance")
    open fun addMoneyToBalance(count: Int) {
        balanceService.addMoney(count)
    }

    @Step ("Check #actor client balance equals {0}")
    open fun checkBalance(expected: Int) {
        assertEquals(expected, balanceService.getBalance() )
    }
}