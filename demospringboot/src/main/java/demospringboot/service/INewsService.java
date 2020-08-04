package demospringboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demospringboot.DTO.NewsDTO;

public interface INewsService {
	NewsDTO save(NewsDTO newsDTO);	
	void delete(Long id);
	List<NewsDTO> findAll(Pageable pageable);
	int getTotalItem();
	void deleteItems(List<Long> ids);
}
