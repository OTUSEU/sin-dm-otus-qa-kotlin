package cucumber.steps

import BalanceService
import io.cucumber.java8.En
import io.cucumber.java8.Ru
import kotlin.test.assertEquals

/**
 * Здесь описывается связка с языковыми конструкциями
 * на них пишутся файлики тестов в ресурсах
 * Названия должны совпадать и тогда плагин их связывает
 * Стиль описания здесь взят а-ля DSL:
 * Я подключил сразу два интерфейса - и так можно
 * на самом деле в cucumber Огромное количество всего что только можно
 * Применять: Договор в команде
 * Делается отдельный Git с пустыми Features файлами
 * В отдельном репозитории весь глю код (склеивающий код)
 * когда изменяются сценарии и/или идет прогон CI
 * Можно совместить Serenite и Cucumber
 * serenite-cucumber-starter
 * Тогда идет использование Serenite как базового фреймворка
 * И все-таки Kotest - можно применить BDD подход
 */
class BalanceServiceSteps : En, Ru {

    init {

        lateinit var balanceService: BalanceService

        Given("A client with zero balance") {
            println("Given zero")
            balanceService = BalanceService()
        }

        When("Add a {int} money to balance") { int: Int ->
            println("When Add")
            balanceService.addMoney(int)
        }

        When("Withdraw {int} money from balance") { int: Int ->
            println("When Withdraw")
            balanceService.withdrawMoney(int)
        }

        Then("Balance should be equal {int}") { int: Int ->
            println("Then Balance")
            assertEquals(int, balanceService.getBalance())
        }

        Дано("Клиент с нулевым балансом") {
            println("Дано Клиент с нулевым балансом")
            balanceService = BalanceService()
        }

        Когда("Добавляется {int} рублей") { int: Int ->
            println("Когда Добавляется")
            balanceService.addMoney(int)
        }

        Когда("Снимается {int} рублей с баланса") { int: Int ->
            println("Когда Снимается")
            balanceService.withdrawMoney(int)
        }

        Тогда("Баланс должен быть {int} рублей") { int: Int ->
            println("Тогда Balance")
            assertEquals(int, balanceService.getBalance())
        }


    }
}