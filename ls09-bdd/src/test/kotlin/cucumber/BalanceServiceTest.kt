package cucumber

import io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite  // т.к в файле ресурса может быть кольшое количество тестовых сценариев
@SelectClasspathResource("balance/feature")     // ссылка на директорию, откуда будем брать ресурсы
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value="cucumber.steps")     // указание пакета, где лежит связующий код
class BalanceServiceTest
