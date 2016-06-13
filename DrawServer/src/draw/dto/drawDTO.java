package draw.dto;

import java.io.Serializable;

public class drawDTO implements Serializable{	
	private int x;
	private int y;
	private int x1;
	private int y1;
	
	public drawDTO(int x, int y, int x1, int y1){
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;			
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}	
}
