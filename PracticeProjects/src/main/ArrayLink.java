package main;

public class ArrayLink {

	int[] link = new int[4];
	
	ArrayLink(int[] link){
		this.link = link;
	}
		
	void setLink(int[] link){
		this.link = link;
	}
	
	void setLink(int set, int link) {
		this.link[set] = link;
	}
	
	int[] getLink() {
		return link;
	}
	
	int getLink(int set) {
		return link[set];
	}
}

