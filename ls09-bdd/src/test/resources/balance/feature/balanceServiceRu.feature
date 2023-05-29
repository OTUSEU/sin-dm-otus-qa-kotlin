# language: ru

Функционал: : Сервис балансов

  @smoke  # Его надо обработать в Сьютах и запускать только отдельные сценарии
  Сценарий: : Client add balance to his account
    Дано A client with zero balance
    Когда Add a 200 money to balance
    Тогда Balance should be equal 200

  @smoke
  Сценарий: : Клиент добавляет баланс
    Дано Клиент с нулевым балансом
    Когда Добавляется 200 рублей
    Тогда Баланс должен быть 200 рублей


#  Scenario: Withdraw from balance
#    Given A client with zero balance
#    When Withdraw 300 money from balance
#    Then Balance should be equal -300
