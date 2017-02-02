import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by roman on 01.02.17.
 */
public class Test1_test {
    Test1 test1 = new Test1();
    @Test
    public void t (){
        Assert.assertEquals(test1.adding(1,2), 3);
    }
//
//    @Test
//    public void tf (){
//        Assert.assertEquals(test1.adding(1,2), 13);
//    }
}
