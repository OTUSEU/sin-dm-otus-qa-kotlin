package kotest

import io.kotest.core.annotation.AutoScan
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.core.listeners.BeforeSpecListener
import io.kotest.core.listeners.IgnoredSpecListener
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.allure.AllureTestReporter
import kotlin.reflect.KClass
// https://habr.com/ru/companies/nspk/articles/520380/
/**
 * Популярность молодой фреймворк Kotest (в прошлом Kotlin Test).
 * Кotest - Это больше чем Spek м Gerkins
 * Тестирование под ключ
 * 10 стилей написания в т.ч BDD
 * Это для домашнего задания
 * Есть листенеры, есть екстеншены
 * аннотация @AutoScan добавляет его ко всем spec в проекте (поэтому 2 шт.)
 * Дает функционал тестирования корутин
 * Дружит с Allure - нужно подключить специальный плагин
 * с Jacocco и со всем остальным
 * много свих assert
 */
@AutoScan
class CustomListener : BeforeSpecListener {
    override suspend fun beforeSpec(spec: Spec) {
        println("This is my custom extension beforeSpec")
    }
}
// с этим не работает - что-то с тестпланом
//object MyKotestConfig : AbstractProjectConfig() {
//    override fun extensions(): List<Extension> = listOf(AllureTestReporter())
//}


