package mvc;

abstract public class Model extends Bean {

	private boolean unsavedChanges = false;
	private String fileName = null;
	
	protected void changed() {
		unsavedChanges = true;
		// TODO: firePropertyChange
	}

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

