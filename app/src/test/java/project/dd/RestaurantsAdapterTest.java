package project.dd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class RestaurantsAdapterTest
{
    private RestaurantsAdapter mUnderTest;
    @Mock private ImageLoader mImageLoader;

    @Before
    public void setup() {
        mUnderTest = new RestaurantsAdapter(mImageLoader);
    }

    @Test
    public void testEmptyAdapterCount() {
        Assert.assertEquals(mUnderTest.getItemCount(), 0);
    }
}
