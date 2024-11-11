package www.silver.vo;

public class BoardVO {
	private String category;
	private String username;
	private String pass;
	private String title;
	private String content;
	private String viewMember;
	private String indate;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getViewMember() {
		return viewMember;
	}
	public void setViewMember(String viewMember) {
		this.viewMember = viewMember;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [category=" + category + ", username=" + username + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", viewMember=" + viewMember + ", indate=" + indate + "]";
	}
}
