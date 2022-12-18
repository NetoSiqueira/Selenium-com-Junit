package runner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import page.TestPage;
import test.TestParametrizacao;
import test.TestRefatorado;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestParametrizacao.class,
        TestRefatorado.class
})
public class SuiteTeste {
}
