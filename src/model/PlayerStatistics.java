package model;

/**
 * This class is to store game player's score.
 *
 */
public class PlayerStatistics {
	private Integer score;
	
	/**
	 * Create PlayerStatistics object.
	 */
	public PlayerStatistics() {
		score = 0;
	}
	
	/**
	 * This is to get score.
	 * @return score.
	 */
	public int getStatistics() {
		return score;
	}
	
	/**
	 * This is to set score.
	 * @param statistics is set as score.
	 */
	public void setStatistics(Integer statistics) {
		this.score = statistics;
	}
	
	/**
	 * This is toString method.
	 * @return score in String format.
	 */
	@Override
	public String toString() {
		return Integer.toString(score);
	}
	
}
