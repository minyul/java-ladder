package domain;

public class Point {

	private Boolean status;

	public Point(Boolean status) {
		this.status = status;
	}

	public Boolean status() {
		return this.status;
	}

	public Boolean previousPointStatus(Point point) {
		return !point.status;
	}
}
