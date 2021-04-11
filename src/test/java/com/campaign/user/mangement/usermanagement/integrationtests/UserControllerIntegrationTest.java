package com.campaign.user.mangement.usermanagement.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.campaign.user.mangement.usermanagement.EmbeddedMongoDbIntegrationTest;
import com.campaign.user.mangement.usermanagement.UsermanagementApplication;
import com.campaign.user.mangement.usermanagement.dto.UserRequestDTO;
import com.campaign.user.mangement.usermanagement.entity.User;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = UsermanagementApplication.class)
@Import(EmbeddedMongoDbIntegrationTest.class)
public class UserControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @TestConfiguration
    static class TestConfig {
		
        @Bean
        public TestRestTemplate restTemplate() {
        	final RestTemplate restTemplate = new RestTemplate();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	        messageConverters.add(converter);
	        restTemplate.setMessageConverters(messageConverters);
	      	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            restTemplateBuilder.configure(restTemplate);
            
            TestRestTemplate testRestTemplate = new TestRestTemplate(restTemplateBuilder);
            return testRestTemplate;
        }
        
    }
    
    @Test
	public void testCreateUser() {
		//Given
    	UserRequestDTO usrRequestDto = new UserRequestDTO();
    	usrRequestDto.setPhoneNumber("1234567890");
    	usrRequestDto.setName("Anisa");
    	usrRequestDto.setAge(20);
    	usrRequestDto.setEmail("gmail@anisa.com");
    	usrRequestDto.setState("Maharashtra");
		HttpEntity<UserRequestDTO> userEntity = new HttpEntity<UserRequestDTO>(usrRequestDto);
    	//When
    	ResponseEntity<String> createUser_Response = this.testRestTemplate.exchange("/CPM/user/createUser", HttpMethod.POST,userEntity, String.class);
		//Then
    	assertEquals(HttpStatus.OK, createUser_Response.getStatusCode());
		assertThat(createUser_Response).isNotNull();
		assertThat(createUser_Response.getBody()).isNotNull();
		assertThat(createUser_Response.getBody()).isNotBlank();
	}
    
    @Test
	public void testGetUser() {
		//Given
    	UserRequestDTO usrRequestDto = new UserRequestDTO();
    	usrRequestDto.setPhoneNumber("1234567890");
    	usrRequestDto.setName("Anisa");
    	usrRequestDto.setAge(20);
    	usrRequestDto.setEmail("gmail@anisa.com");
    	usrRequestDto.setState("Maharashtra");
		HttpEntity<UserRequestDTO> userEntity = new HttpEntity<UserRequestDTO>(usrRequestDto);
    	ResponseEntity<String> createUser_Response = this.testRestTemplate.exchange("/CPM/user/createUser", HttpMethod.POST,userEntity, String.class);
    	String userId = createUser_Response.getBody().trim();
		
    	//When
		ResponseEntity<User> getUser_Response = this.testRestTemplate.exchange("/CPM/user/getUser/" +userId , HttpMethod.GET,null, User.class);
		
		//Then
		User db_user = getUser_Response.getBody();
		assertEquals(HttpStatus.OK, createUser_Response.getStatusCode());
		assertThat(createUser_Response).isNotNull();
		assertThat(createUser_Response.getBody()).isNotNull();
		assertEquals(HttpStatus.OK, getUser_Response.getStatusCode());
		assertThat(getUser_Response).isNotNull();
		assertThat(getUser_Response.getBody()).isNotNull();
		assertEquals(db_user.getPhoneNumber(), usrRequestDto.getPhoneNumber());
		assertEquals(db_user.getName(), usrRequestDto.getName());
		assertEquals(db_user.getAge(), usrRequestDto.getAge());
		assertEquals(db_user.getEmail(), usrRequestDto.getEmail());
		assertEquals(db_user.getState(), usrRequestDto.getState());
		assertEquals(db_user.getId(), userId);
	}
    
    @Test
    public void shouldCreateNewObjectInEmbeddedMongoDb() {
        // given
    	DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();
        // when
        mongoTemplate.save(objectToSave, "collection");
        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key").containsOnly("value");
    }
}
