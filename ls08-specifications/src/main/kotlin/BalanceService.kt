/**
 * Взят небольшой класс для тестов
 * класс, который управляет балансом пользователя
 */
class BalanceService {
    
    private var balance = 0

    /**
     * поплнение баланса
     */
    fun addBalance(count: Int) {
        balance += count
    }

    /**
     * уменьшение баланса
     */
    fun removeBalance(count: Int) {
        balance -= count
    }

    /**
     * получить текущее состояние баланса
     */
    fun getBalance() = balance
}