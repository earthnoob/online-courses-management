package OCM.Miscellaneous;

import java.io.File;

public class FileIO {
	private String parentNode;
	
	public FileIO() {
		setParentNode("ServerData");
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	public void createNewFolder(String childNode) {
		String format = String.format("%s/%s", parentNode, childNode);
		new File(format).mkdirs();
		
		System.out.println("Directory made!");
	}
	
	public static void main(String[] args) {
		new FileIO().createNewFolder("aaa");
	}
}
