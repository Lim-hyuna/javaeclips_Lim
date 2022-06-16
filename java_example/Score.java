package day23;

public class Score {
	
	private String subject;
	private int middleScore, finalScore, performScore;

	
	@Override //출력 
	public String toString() {
		double total = middleScore*0.4 + finalScore*0.5 + performScore*0.1;
		return subject + " [중간: " + middleScore+ ", 기말: " + finalScore
				+ ", 수행: " + performScore + ", 총점: "+total + "]";
	}


	//생성자 
	public Score(String subject, int middleScore, int finalScore, int performScore) {
		this(subject);
		setMiddleScore(middleScore);
		setFinalScore(finalScore);
		setPerformScore(performScore);
	}

	public Score(String subject) { 
		this.subject = subject;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	public int getMiddleScore() {
		return middleScore;
	}

	public void setMiddleScore(int middleScore) {
		if(middleScore < 0 || middleScore>100)
			throw new RuntimeException("중간고사는 0~100사이의 정수를 입력하세요.");
		this.middleScore = middleScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		if(finalScore < 0 || finalScore>100)
			throw new RuntimeException("기말고사는 0~100사이의 정수를 입력하세요.");
		this.finalScore = finalScore;
	}

	public int getPerformScore() {
		return performScore;
	}

	public void setPerformScore(int performScore) {
		if(performScore < 0 || performScore>100)
			throw new RuntimeException("수행평가는 0~100사이의 정수를 입력하세요.");
		this.performScore = performScore;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
}
