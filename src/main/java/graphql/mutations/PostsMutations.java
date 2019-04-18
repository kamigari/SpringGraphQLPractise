package graphql.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import graphql.beans.Post;
import graphql.persistence.PostsRepository;

@Service
public class PostsMutations implements GraphQLMutationResolver {

	@Autowired
	private final PostsRepository postsRepository;
	
	public PostsMutations(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}
	
	public Post getAddPosts(Post post) {
		return this.postsRepository.save(post);
	}
	
}
