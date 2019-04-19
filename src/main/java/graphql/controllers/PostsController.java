package graphql.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import graphql.beans.Post;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPosts(){
		Map< String, String> jsonValues = new HashMap< String, String>();
		jsonValues.put("query", "query{posts{id authorId text}}");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(new JSONObject(jsonValues).toString(), headers);
		return new RestTemplate().exchange("http://localhost:8080/graphql", HttpMethod.POST, entity, String.class);
	}
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPosts(@PathVariable("id") String id){
		Map< String, String> jsonValues = new HashMap< String, String>();
		jsonValues.put("query", "query{postsId(id: " + id + "){id authorId text}}");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(new JSONObject(jsonValues).toString(), headers);
		return new RestTemplate().exchange("http://localhost:8080/graphql", HttpMethod.POST, entity, String.class);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setPosts(@RequestBody Post post){
		Map< String, String> jsonValues = new HashMap< String, String>();
		jsonValues.put("query", "mutation{addPosts(post: {authorId: "+ post.getAuthorId() +", text: \""+ post.getText() +"\"}){id authorId text}}");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(new JSONObject(jsonValues).toString(), headers);
		return new RestTemplate().exchange("http://localhost:8080/graphql", HttpMethod.POST, entity, String.class);
	}	
	
}
