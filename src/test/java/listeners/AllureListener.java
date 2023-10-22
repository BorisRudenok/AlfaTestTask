package listeners;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utils.Utils;

public class AllureListener implements AfterTestExecutionCallback {
    Utils utils = new Utils();

    /**
     * Создание скриншота в случае падения теста и прикрепление к отчету
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {
            utils.takeScreenshot("error");
        }
    }
}
