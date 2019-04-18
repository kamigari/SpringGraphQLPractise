package graphql.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import graphql.beans.Post;

@Repository
public interface PostsRepository extends CrudRepository<Post, Integer> {}
