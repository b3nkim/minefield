package mvc;

public class Model extends Bean {

	boolean unsavedChanges = false;
	String fileName = null;
	
	public boolean getUnsavedChanges() {
		return unsavedChanges;
	}
	
	public void setUnsavedChanges(boolean unsavedChanges) {
		this.unsavedChanges = unsavedChanges;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


}

