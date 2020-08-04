package demospringboot.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demospringboot.DTO.NewsDTO;
import demospringboot.convert.NewsConvert;
import demospringboot.entity.CategoryEntity;
import demospringboot.entity.NewsEntity;
import demospringboot.repository.CategoryRepository;
import demospringboot.repository.NewsRepository;
import demospringboot.service.INewsService;

@Service
public class NewsServiceImp implements INewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewsConvert newsConvert;

	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		NewsEntity newsEntity;
		if (newsDTO.getId() != null) {
			NewsEntity oldNews = newsRepository.findOne(newsDTO.getId());
			newsEntity = newsConvert.convertToEntity(newsDTO, oldNews);
		} else {
			newsEntity = newsConvert.convertToEntity(newsDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategoryEntity(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConvert.convertToDTO(newsEntity);
	}

	@Override
	public void delete(Long id) {
	
			newsRepository.delete(id);
		
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> results= new ArrayList<>();	
		List<NewsEntity> listEntitys= newsRepository.findAll(pageable).getContent(); 
		for (NewsEntity item : listEntitys) {
			NewsDTO newsDTO= newsConvert.convertToDTO(item);
			results.add(newsDTO);
		}
		return results;
	}

	@Override
	public int getTotalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public void deleteItems(List<Long> ids) {
		for (Long id : ids) {
			newsRepository.delete(id);
		}
	}

}
