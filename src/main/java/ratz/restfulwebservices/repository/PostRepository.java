package ratz.restfulwebservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratz.restfulwebservices.domain.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
