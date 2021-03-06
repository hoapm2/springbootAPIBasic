package demospringboot.DTO;


// DTO là nơi transfer data giữa controller và view hoặc API và client
// Entity là đối tượng maping với tables trong database
public class NewsDTO extends AbstractDTO <NewsDTO> { 
	
	
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private String categoryCode;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	
	
}
