package integration;

import entities.AccessLevel;
import org.junit.Ignore;
import services.implementation.AccessLevelImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
public class AccessLevelImplTest {
    AccessLevelImpl accessLevelimpl;
    AccessLevel accessLevel = new AccessLevel("test");
    @Ignore
    @Before
    public void TestInitTst() {
        accessLevelimpl = new AccessLevelImpl();
    }

    @Ignore
    @Test
    public void TestCreateEntityTest() throws Exception {

        accessLevelimpl.createEntity(accessLevel);
        Assert.assertEquals(accessLevelimpl.
                getEntityById(accessLevel.getAccessLevelId()), accessLevel);

    }

    @Ignore
    @Test
    public void getEntityById() throws Exception {
        accessLevel = accessLevelimpl.getEntityById(3);
        Assert.assertEquals(accessLevel.getStatus(), "Manager");
    }

    @Ignore
    @Test
    public void updateEntity() throws Exception {
        if (accessLevel.getStatus().equals("test")) {
            accessLevel.setStatus("test1");
            accessLevelimpl.updateEntity(accessLevel);
            Assert.assertEquals(accessLevel.getStatus(), "test1");
        } else {
            accessLevel.setStatus("test");
            accessLevelimpl.updateEntity(accessLevel);
            Assert.assertEquals(accessLevel.getStatus(), "test1");
        }
    }
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void deleteEntity() {
        accessLevelimpl.deleteEntity(accessLevelimpl.getEntityById(accessLevel.getAccessLevelId()));


    }
    @Ignore
    @Test
    public void getAll() throws Exception {
        Assert.assertNotEquals(accessLevelimpl.getAll().size(), 0);
    }

}