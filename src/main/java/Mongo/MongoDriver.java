package Mongo;

import com.google.gson.JsonArray;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

public class MongoDriver {
    private MongoDatabase db;
    private MongoClient mongoClient;
    private String DATA_BASE_NAME = "magneto";
    private String STATS_COLLECTION_NAME = "stats";
    private String STATS_COLLECTION_FIELD_ADN = "adn";
    private String STATS_COLLECTION_FIELD_MUTANT = "mutant";

    private static MongoDriver instance = null;

    public static MongoDriver getInstance(){
        if(instance==null){
            instance = new MongoDriver();
        }
        return instance;
    }


    public void initialize() {
        MongoClientURI mongoURI = new MongoClientURI("mongodb://heroku_5km74hlb:jhgqbumqa0ubctodgn6nloaoj9@ds151066.mlab.com:51066/heroku_5km74hlb");
        mongoClient = new MongoClient(mongoURI);
        db = mongoClient.getDatabase(DATA_BASE_NAME);
        db.getCollection(STATS_COLLECTION_NAME).createIndex(Indexes.text(STATS_COLLECTION_FIELD_ADN));
    }

    public void saveDNA(JsonArray dna, boolean isMutant){

        db.getCollection(STATS_COLLECTION_NAME)
                .insertOne(new Document()
                        .append(STATS_COLLECTION_FIELD_ADN,dna)
                        .append(STATS_COLLECTION_FIELD_MUTANT,isMutant)
                );
    }
    public Document findDNAStats(){
        Document findQueryHuman = new Document(STATS_COLLECTION_FIELD_MUTANT,false);
        long resultCountHuman = db.getCollection(STATS_COLLECTION_NAME).count(findQueryHuman);
        Document findQueryMutant = new Document(STATS_COLLECTION_FIELD_MUTANT, true);
        long resultCountMutant = db.getCollection(STATS_COLLECTION_NAME).count(findQueryMutant);
        Document result = new Document();
        result.append("count_human_dna",resultCountHuman);
        result.append("count_mutant_dna",resultCountMutant);
        if(resultCountHuman > 0){
            result.append("ratio",resultCountMutant/resultCountHuman);
        }else{
            result.append("ratio","undefined");
        }

        return result;
    }


}