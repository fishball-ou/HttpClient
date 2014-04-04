package oukq.ui;

class Test {
	private String name;
	private Integer progress;

	public Test(String name, Integer progress) {
		this.name = name;
		this.progress = progress;
	}

	public void setName(String str) {
		name = str;
	}

	public void setProgress(Integer str) {
		progress = str;
	}

	public String getName() {
		return name;
	}

	public Integer getProgress() {
		return progress;
	}
}
