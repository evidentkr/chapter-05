package com.rubypaper.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);

	//Like 연산자
	List<Board> findByContentContaining(String searchKeyword);
	
	//여러 조건 (제목/본문)
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	//정렬
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	//페이징과 정렬 처리
	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}
