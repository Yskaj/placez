package com.sights.service;

import com.sights.dto.CommentDTO;
import com.sights.entity.*;
import com.sights.repository.CommentRepository;
import com.sights.repository.PlaceRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    private EntityManager entityManager;

    public CommentService(CommentRepository commentRepository, PlaceRepository placeRepository) {
        this.commentRepository = commentRepository;
        this.placeRepository = placeRepository;
    }

    public Comment create(CommentDTO dto) {
        Comment comment = new Comment(dto.getPlace_id(), dto.getComment(), dto.getRating());
        return commentRepository.save(comment);
    }

    public List<Comment> readAll() {
        return commentRepository.findAll();
    }

    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public PlaceInformation getPlaceInformation(String sight) {
        Place place = placeRepository.findFirstByName(sight);
        if (place != null) {
            String query = String.format("select comment from comments where place_id=%s",place.getId());
            List comments = entityManager.createNativeQuery(
                    query, Comments.class).getResultList();
            System.out.println(comments.size()>0);
          //  Optional<List<Comment>> comments = commentRepository.getCommentByPlaceId(place.getId());

//            if (comments.get().get(0).getComment()!=null) {
//                return new PlaceInformation(place.getName(), place.getAvg_rating(), comments.get());
//            } else {
//                List<Comment> emptyComment = List.of(new Comment("Никто не оставил комментарий, будь первым!"));
//                return new PlaceInformation(place.getName(), place.getAvg_rating(), emptyComment);
//            }
        }
        return new PlaceInformation(String.format("Не нашлось местоположения с именем %s", sight));
    }
}
