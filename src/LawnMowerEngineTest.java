import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by antoinevergos on 28/05/2018.
 */
public class LawnMowerEngineTest {

    LawnMowerEngine engine;

    String[] testData ={
            "5 5",
            "1 2 N",
            "LFLFLFLFF",
            "3 3 E",
            "FFRFFRFRRF"
    };

    String[] illegalData1 ={
            "5 5",
    };


    String[] illegalData2 ={
            "5 5",
            "1 2 N",
    };

    @Before
    public void init(){
        engine = new LawnMowerEngine();
    }

    @Test
    public void testData(){
        List<String> result = engine.processFile(testData);
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalData(){
        engine.processFile(illegalData1);
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalData2(){
        engine.processFile(illegalData2);
    }

}