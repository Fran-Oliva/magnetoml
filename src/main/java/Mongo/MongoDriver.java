package Mongo;

import com.google.gson.JsonArray;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;
import org.bson.Document;

public class MongoDriver {
    private MongoDatabase db;
    private MongoClient mongoClient;
    private String STATS_COLLECTION_NAME = "stats";
    private String STATS_COLLECTION_FIELD_ADN = "adn";
    private String STATS_COLLECTION_FIELD_MUTANT = "mutant";
    private String STATS_COLLECTION_FIELD_ID = "_id";

    private static MongoDriver instance = null;

    public static MongoDriver getInstance(){
        if(instance==null){
            instance = new MongoDriver();
        }
        return instance;
    }


    public void initialize() {
        MongoClientURI mongoURI = new MongoClientURI("mongodb://fran:lab6996mongo@ds151066.mlab.com:51066/heroku_5km74hlb");
        mongoClient = new MongoClient(mongoURI);
        db = mongoClient.getDatabase(mongoURI.getDatabase());
        db.getCollection(STATS_COLLECTION_NAME).createIndex(Indexes.text(STATS_COLLECTION_FIELD_ADN));
    }

    public void saveDNA(JsonArray dna, boolean isMutant){

        Object dnaStr = JSON.parse(dna.toString());
        try{
            db.getCollection(STATS_COLLECTION_NAME)
                    .insertOne(new Document()
                            .append(STATS_COLLECTION_FIELD_ID,dna.toString())
                            .append(STATS_COLLECTION_FIELD_ADN,dnaStr)
                            .append(STATS_COLLECTION_FIELD_MUTANT,isMutant)
                    );
        }catch (MongoWriteException ex){
            return;
        }

    }
    public Document findDNAStats(){
        Document findQueryHuman = new Document(STATS_COLLECTION_FIELD_MUTANT,false);
        long resultCountHuman = db.getCollection(STATS_COLLECTION_NAME).count(findQueryHuman);
        Document findQueryMutant = new Document(STATS_COLLECTION_FIELD_MUTANT, true);
        long resultCountMutant = db.getCollection(STATS_COLLECTION_NAME).count(findQueryMutant);
        Document result = new Document();
        result.append("count_human_dna",String.valueOf(resultCountHuman));
        result.append("count_mutant_dna",String.valueOf(resultCountMutant));
        if(resultCountHuman > 0){
            float ratioResult = (float)resultCountMutant / (float)resultCountHuman;
            result.append("ratio",String.valueOf(ratioResult));
        }else{
            result.append("ratio",resultCountMutant);
        }
        return result;
    }


}
