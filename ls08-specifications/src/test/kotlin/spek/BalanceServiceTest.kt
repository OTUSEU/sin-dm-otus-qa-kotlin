package spek

/**
 *  СПЕЦИФИКАЦМЯ SPEK
 */
import BalanceService
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.specification.describe
import kotlin.test.DefaultAsserter.assertEquals

/**
 * пример таста в стиле спецификации на Spek
 * - чтобы запускать нужен плагин Spek - появятся зеленые стартеры (не появились)
 * или запускать через Gradle > ls08-specifications > verification > test > Run
 *
 */
class BalanceServiceTest : Spek({

    // Before After исполняет в диковатом -  своем порядке
    // берется из org.spekframework.spek2.dsl
    // Это надо учитывать - есть в документации
    // лучше данные задавать через memoized(CachingMode.TEST)

    beforeEachTest {
        // здесь можно задавать например состояние API итд
        println("Root before each test")
    }

    afterEachTest {
        println("Root after each test")
    }

    beforeGroup {
        println("Root before group")
    }

    afterGroup {
        println("Root after group")
    }

    beforeEachGroup {
        println("Root before each group")
    }

    describe("Balance service") {
        /**
         * задается balanceService через делегат
         * CachingMode.TEST - каждый тест будет использовать свой свежий экземпляр данных
         * CachingMode.SCOPE - каждый тест будет использовать один и тот же экземпляр данных
         */
        val balanceService by memoized(CachingMode.TEST) {
        //val balanceService by memoized(CachingMode.SCOPE) {
            // через делегата вспоминаем синтаксис
            BalanceService()
        }

        // вложенная стуктура  describe (описаний)
        // все проверки на добавляемые суммы можно закинуть в эту группу
        describe("Adding  balance nested") {
            // it - это уже сам тест (либо группа либо тест)
            it("nested Balance should increase") {
                balanceService.addBalance(100)
                assertEquals("Balance nested != 100", 100, balanceService.getBalance())
            }
        }
        describe("Removing  balance nested") {
            // it - это уже сам тест (либо группа либо тест)
            it("nested Balance should remove") {
                balanceService.removeBalance(100)
                assertEquals("Balance nested != -100", -100, balanceService.getBalance())
                // для memoized(CachingMode.SCOPE)
                //assertEquals("Balance nested != 0", 0, balanceService.getBalance())
            }
        }

        beforeEachTest {
            println("before each test")
        }

        afterEachTest {
            println("after each test")
        }

        beforeGroup {
            println("before group")
        }

        afterGroup {
            println("after group")
        }


        it("Adding a balance") {
            balanceService.addBalance(200)
            assertEquals("Balance != 200", 200, balanceService.getBalance())
        }

        it("Remove balance") {
            balanceService.removeBalance(200)
            assertEquals("Balance != -200", -200, balanceService.getBalance())
            // memoized(CachingMode.SCOPE)
           // assertEquals("Balance != -200", 0, balanceService.getBalance())
        }
    }
})