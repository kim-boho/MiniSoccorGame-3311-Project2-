package model;


public class PlayerStatistics {
	private Integer score;
	public PlayerStatistics() {
		score = 0;
	}
	
	public int getStatistics() {
		return score;
	}
	
	public void setStatistics(Integer statistics) {
		this.score = statistics;
	}
	
	@Override
	public String toString() {
		return Integer.toString(score);
	}
	
}
