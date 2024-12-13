package com.sights.repository;

import com.sights.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    Optional<List<Comment>> getCommentByPlaceId(Long Place_id);
}
