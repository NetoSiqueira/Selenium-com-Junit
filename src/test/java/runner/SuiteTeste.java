package runner;


import core.BasePage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TestGoogle;
import test.TesteCadastro;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       // TestParametrizacao.class,
//             TestRefatorado.class,
//        TesteCadastro.class,
        TestGoogle.class
})
public class SuiteTeste extends BasePage {



}
