package com.campaign.user.mangement.usermanagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClients;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@TestConfiguration
public class EmbeddedMongoDbIntegrationTest
{
	 private static final String CONNECTION_STRING = "mongodb://%s:%d";

	    private MongodExecutable mongodExecutable;
	    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void beforeEach() throws Exception {
    	 String ip = "localhost";
         int port = 27017;
         IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
             .net(new Net(ip, port, Network.localhostIsIPv6()))
             .build();
         MongodStarter starter = MongodStarter.getDefaultInstance();
         mongodExecutable = starter.prepare(mongodConfig);
         mongodExecutable.start();
         mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
    }

    @AfterEach
    public void afterEach() throws Exception {
    	mongodExecutable.stop();
    }

}
