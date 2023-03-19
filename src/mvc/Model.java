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
		boolean flag = this.unsavedChanges;
		this.unsavedChanges = unsavedChanges;
		firePropertyChange("unsavedChanges", flag, unsavedChanges);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		String oldFileName = this.fileName;
		this.fileName = fileName;
		firePropertyChange("fileName", oldFileName, fileName);
	}
	
}

