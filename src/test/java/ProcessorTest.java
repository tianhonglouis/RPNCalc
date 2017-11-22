import com.test.demo.command.CmdInvoker;
import com.test.demo.core.Processor;
import com.test.demo.exception.InsufficientParamException;
import com.test.demo.exception.UnknownOperatorException;
import com.test.demo.provider.StackProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

    private CmdInvoker invoker;
    private Processor processor;

    @Before
    public void init(){
        invoker = new CmdInvoker();
        processor = new Processor();
        processor.setCommandInvoker(invoker);
        StackProvider.clear();
    }

    @Test
    public void testHappyPath() throws Exception {
        String testcase = "5 4 3 undo * 5 / 3 + 4 -";
        processor.process(testcase);
        Assert.assertEquals(StackProvider.pop(), 3, 0.0000000001);
    }

    @Test(expected = InsufficientParamException.class)
    public void testInsufficientParamException() throws Exception {
        String testcase = "1 2 3 * 5 + * * 6 5";
        processor.process(testcase);
    }

    @Test(expected = UnknownOperatorException.class)
    public void testUnknownOperatorException() throws Exception {
        String testcase = "1 2 3 * mod";
        processor.process(testcase);
    }


}
