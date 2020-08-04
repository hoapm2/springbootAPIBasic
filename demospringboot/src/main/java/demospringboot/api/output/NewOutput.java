package demospringboot.api.output;

import java.util.ArrayList;
import java.util.List;

import demospringboot.DTO.NewsDTO;

public class NewOutput {
	private int page;
	private int totalPage;
	private List<NewsDTO> listResults = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<NewsDTO> getListResults() {
		return listResults;
	}
	public void setListResults(List<NewsDTO> listResults) {
		this.listResults = listResults;
	}
	

	
}
