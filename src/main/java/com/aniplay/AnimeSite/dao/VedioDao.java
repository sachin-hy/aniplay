package com.aniplay.AnimeSite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aniplay.AnimeSite.dto.CommentWithUserNameDTO;
import com.aniplay.AnimeSite.entities.UserDetail;
import com.aniplay.AnimeSite.entities.VedioComment;

public interface VedioDao extends JpaRepository<VedioComment,Long>{

	@Query("SELECT new com.aniplay.AnimeSite.dto.CommentWithUserNameDTO(c.commentId, c.videoId, c.commentText, c.commentDate, u.name) " +
	           "FROM VedioComment c JOIN c.user u WHERE c.videoId = :videoId")
	    List<CommentWithUserNameDTO> findCommentsWithUserName(@Param("videoId") String videoId);


}
