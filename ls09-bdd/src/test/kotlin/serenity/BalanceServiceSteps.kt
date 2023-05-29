package serenity
//import net.thucydides.core.annotations.Step
//import net.thucydides.core.steps.ScenarioSteps
//import kotlin.test.assertEquals
//
//open class BalanceServiceSteps : ScenarioSteps() {
//
//    private val balanceService = BalanceService()
//
//    @Step("#actor add {0} money to balance")
//    open fun addMoneyToBalance(count: Int) {
//        balanceService.addMoney(count)
//    }
//
//    @Step("#actor withdraw {0} money from balance")
//    open fun withdrawMoneyFromBalance(count: Int) {
//        println("Client withdraw $count money from his balance")
//        balanceService.withdrawMoney(count)
//    }
//
//    @Step("#actor get balance")
//    open fun getBalanceCount(): Int {
//        println("Client requests his balance")
//        return balanceService.getBalance()
//    }
//
//    @Step("Check balance. Expected: {0}. Actual: {1}")
//    open fun checkBalance(expected: Int, count: Int) {
//        println("Check balance is correct")
//        assertEquals(expected, count)
//    }
//}