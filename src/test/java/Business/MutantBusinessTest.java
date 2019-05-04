package Business;

import Mongo.MongoDriver;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MutantBusinessTest {
    @Before
    public void startDB(){
        MongoDriver.getInstance().initialize();
    }
    @Test
    public void verify() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("dna","GATTCG,CAGTGG,TCAGTA,GTCAGT,TATCAT,GTCTCC");
        MutantBusiness mutantB = new MutantBusiness();
        Object result = mutantB.verify(json);
        assertNotNull(result);
    }

    @Test
    public void getStats() throws Exception {
        MutantBusiness mutantBusiness= new MutantBusiness();
        Object result = mutantBusiness.getStats();
        Assert.assertNotNull(result);
    }

}