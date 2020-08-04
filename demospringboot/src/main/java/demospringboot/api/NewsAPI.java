package demospringboot.api;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demospringboot.DTO.NewsDTO;
import demospringboot.api.output.NewOutput;
import demospringboot.service.INewsService;
	
	//@Controller
	@RestController
	public class NewsAPI {
		
		@Autowired
		private INewsService newsService;
	
		//@RequestMapping (value = "/new", method = RequestMethod.POST)
		
		//@ResponseBody
		@PostMapping(value = "/new")
		public NewsDTO createNews(@RequestBody NewsDTO model) {	
			return newsService.save(model);
		}
		
		@GetMapping(value = "/new")
		public NewOutput showNews(@RequestParam("page") int page, @RequestParam("limit") int limit) {
			NewOutput results= new NewOutput();
			results.setPage(page);
			Pageable pageable= new PageRequest(page-1, limit);
			results.setListResults(newsService.findAll(pageable));
			results.setTotalPage((int) Math.ceil((double)(newsService.getTotalItem()) / limit));
			return results;
		}
		
		@PutMapping(value = "/new/{id}")
		public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
			model.setId(id);
			return newsService.save(model);
		}
		
		@DeleteMapping(value = "/new/{id}")
		public void deleteNews(@PathVariable("id") long id) {
			newsService.delete(id);
		}
		
		@DeleteMapping(value = "/new")
		public void deleteAlotNews(@RequestBody List<Long> ids) {
			for (Long id : ids) {
				newsService.delete(id);
			}
		}
	}
