package demospringboot.convert;

import org.springframework.stereotype.Component;

import demospringboot.DTO.NewsDTO;
import demospringboot.entity.NewsEntity;import demospringboot.serviceImp.NewsServiceImp;

@Component
public class NewsConvert {
	public NewsEntity convertToEntity(NewsDTO newsDTO) {
		NewsEntity entity= new NewsEntity();
		entity.setTitle(newsDTO.getTitle());
		entity.setThumbnail(newsDTO.getThumbnail());
		entity.setContent(newsDTO.getContent());
		entity.setShortDescription(newsDTO.getShortDescription());
		return entity;
	}
	public NewsDTO convertToDTO(NewsEntity newsEntity) {
		NewsDTO newsDTO= new NewsDTO();
		if (newsEntity.getId()!=null) {
			newsDTO.setId(newsEntity.getId());
		}
		newsDTO.setContent(newsEntity.getContent());
		newsDTO.setThumbnail(newsEntity.getThumbnail());
		newsDTO.setShortDescription(newsEntity.getShortDescription());
		newsDTO.setTitle(newsEntity.getTitle());
		newsDTO.setCreateDate(newsEntity.getCreatedDate()); 
		newsDTO.setCreateBy(newsEntity.getCreatedBy());
		newsDTO.setModifiedBy(newsEntity.getModifiedBy());
		newsDTO.setModifiedDate(newsEntity.getModifiedDate());
		return newsDTO;
	}
	public NewsEntity convertToEntity(NewsDTO newsDTO, NewsEntity entity) {
		entity.setTitle(newsDTO.getTitle());
		entity.setThumbnail(newsDTO.getThumbnail());
		entity.setContent(newsDTO.getContent());
		entity.setShortDescription(newsDTO.getShortDescription());
		return entity;
	}
}
