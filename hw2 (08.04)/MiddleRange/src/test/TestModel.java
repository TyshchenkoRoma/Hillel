package test;

import com.Hillel.tyshchenko.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by roman on 10.04.16.
 */
public class TestModel {
    @Test
    public void testFindMiddleValue() {
        Model model = new Model();
        int[] arrayTest = {1, 2, 3};
        int[] arrayTest1 = {5, 5, 5};
        int[] arrayTest2 = {0, 0, 0};

        model.findMiddleValue(arrayTest);

        Assert.assertEquals((long) (model.findMiddleValue(arrayTest)), 2);
        Assert.assertEquals((long) (model.findMiddleValue(arrayTest1)), 5);
        Assert.assertEquals((long) (model.findMiddleValue(arrayTest2)), 0);

    }
}
