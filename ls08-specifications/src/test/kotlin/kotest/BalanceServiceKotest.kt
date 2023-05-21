package kotest

import BalanceService
import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import kotlin.test.assertEquals

/**
 *  * Популярность молодой фреймворк Kotest (в прошлом Kotlin Test).
 *  * Кotest - Это больше чем Spek м Gerkins
 *  * Тестирование под ключ
 *  * 10 стилей написания в т.ч BDD
 *  * Это для домашнего задания
 *  * Есть листенеры, есть екстеншены
 *  * аннотация @AutoScan добавляет его ко всем spec в проекте (поэтому 2 шт.)
 *  * Дает функционал тестирования корутин
 *  * Дружит с Allure - нужно подключить специальный плагин
 *  * с Jacocco и со всем остальным
 *  * много свих assert
 *
 * Наследуемся от FunSpec - это один из 10 стилей написания
 * after и before очень много
 * Для ктестов есть плагин - появляется стартер
 * через .config можем настраивать группу
 * есть отдельные функции, которые начинаются с X - будут выключены, пока не поменяем на тест
 * IsolationMode - как менять/сохранять тестовые данные
 *
 * В котесте огромное количество различного функционала - практически все что нужно
 * и движок и дата драйвер тест и проперти тестинг с различного вида генераторами
 * огромные возможности для конфигов, расширений, параллелизма итд
 * плюс библиотека ассертов супербогатая
 * и 10 стилей в которых тонешь
 *
 */
@OptIn(ExperimentalKotest::class)
class BSFunTest : FunSpec({
// пишем в лямбдах тпеже как и в Gerkins
    isolationMode = IsolationMode.SingleInstance

    // подключаем наше расширение или @AutoScan
    // extension(CustomListener())

    context("Balance service").config() {
    //context("Balance service") {
        lateinit var balanceService:BalanceService
        beforeTest {
            balanceService = BalanceService()
        }
        afterTest {
            println("after test")
        }
        test("Add a balance to client").config() {
       //test("Add a balance to client") {
            balanceService.addBalance(200)
            balanceService.getBalance() shouldBeEqualComparingTo 200
        }
        test("Withdraw balance") {
            balanceService.removeBalance(200)
            //assertEquals(0, balanceService.getBalance())
            assertEquals(-200, balanceService.getBalance())
        }
    }
})

class BSFutureSpec : BehaviorSpec({
    given("A balance Service") {
        val balanceService = BalanceService()
        `when`("Adding f balance") {
            balanceService.addBalance(100)
            then("Balance should increase") {
                balanceService.getBalance() shouldBeEqualComparingTo 100
            }
        }
    }
})
