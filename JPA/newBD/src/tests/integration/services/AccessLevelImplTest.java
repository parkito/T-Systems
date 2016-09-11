package integration.services;

import entities.AccessLevel;
import integration.implementation.AccessLevelImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
public class AccessLevelImplTest {
    AccessLevelImpl accessLevelimpl;
    AccessLevel accessLevel;

    @Before
    public void initTst() {
        accessLevelimpl = new AccessLevelImpl();
        accessLevel = new AccessLevel("test");
    }

    @Test
    public void createEntityTest() throws Exception {

        accessLevelimpl.createEntity(accessLevel);
        Assert.assertEquals(accessLevelimpl.
                getEntityById(accessLevel.getAccessLevelId()), accessLevel);

    }

    @Test
    public void getEntityById() throws Exception {
        accessLevel = accessLevelimpl.getEntityById(3);
        Assert.assertEquals(accessLevel.getStatus(), "Manager");
    }


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

    @Test(expected = IllegalArgumentException.class)
    public void deleteEntity() {
        accessLevelimpl.deleteEntity(accessLevelimpl.getEntityById(accessLevel.getAccessLevelId()));


    }

    @Test
    public void getAll() throws Exception {
        Assert.assertNotEquals(accessLevelimpl.getAll().size(), 0);
    }

}