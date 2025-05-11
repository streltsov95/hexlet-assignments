package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    private PostDTO postToDTO(Post post) {
        var postDTO = new PostDTO();

        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());

        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream()
                .map(this::commentToDTO)
                .toList();

        postDTO.setComments(commentsDTO);

        return postDTO;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var dto = new CommentDTO();

        dto.setId(comment.getId());
        dto.setBody(comment.getBody());

        return dto;
    }

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<PostDTO> index() {
        var posts = postRepository.findAll();

        var dto = posts.stream()
                .map(this::postToDTO)
                .toList();

        return dto;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return postToDTO(post);
    }
}
// END
