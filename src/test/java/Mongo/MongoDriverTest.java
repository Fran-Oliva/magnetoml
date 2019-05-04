package Mongo;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MongoDriverTest {
    @Before
    public void startDB(){
        MongoDriver.getInstance().initialize();
    }
    @Test
    public void getInstance() throws Exception {
        MongoDriver mongo = MongoDriver.getInstance();
        assertNotNull(mongo);
    }

    @Test
    public void findDNAStats() throws Exception {
        Document find = MongoDriver.getInstance().findDNAStats();
        assertNotNull(find);
    }

}