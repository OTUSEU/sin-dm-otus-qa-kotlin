package spek

import BalanceService
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals
/**
 *  СПЕЦИФИКАЦМЯ GERKIN
 *  SPEK для Selenium - да почему нет
 *  SPEK - это способ организации данных
 *  вместо  val balanceService by может быть
 *  Selenium web driver и он может запускаться
 *  в Given напр переход на стараницу Loginа
 *  в When вводиться логина
 *  в Then проверяться вход
 *  Selenide тоже может
 *  Это библиотека написанная специально под котлин
 *  Минус - здесь слишком много всего - океан
 */
class BalanceServiceGherkinTest : Spek({

    Feature("Balance service") {
        // TEST - аккуратнее - здесь каждый When Then является тестом и будет 0
        //val balanceService by memoized(CachingMode.TEST) { BalanceService() }
        val balanceService by memoized(CachingMode.EACH_GROUP) { BalanceService() }
        //val balanceService by memoized { BalanceService() }

        // Есть before Scenario, Each test итд
        Scenario("Client add balance") {
            // Given необязательно
            Given("Initial balance"){
                balanceService.addBalance(100)
            }

            When("Add a balance") {
                balanceService.addBalance(100)
            }
            Then("Balance should be equal 200") {
                assertEquals( 200, balanceService.getBalance())
            }
        }
        // Scenario могут лежать рядом могут быть вложены
        Scenario("Client withdraw money") {
            When("Withdraw a balance") {
                balanceService.removeBalance(200)
            }
            Then("Balance should be -200") {
                assertEquals(-200, balanceService.getBalance())
            }
        }
    }

})
