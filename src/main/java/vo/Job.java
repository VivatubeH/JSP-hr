package vo;

public class Job {

	private String jobId; // 직종 아이디
	private String jobTitle; // 직종명
	private int minSalary; // 최소 급여
	private int maxSalary; // 최대 급여
	
	// 기본 생성자
	public Job() {}

	// 빌더 패턴 적용을 위한 생성자 생성
	public Job(String jobId, String jobTitle, int minSalary, int maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	// Getter 및 Setter 생성
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	/**
	 * builder() 객체를 반환할 builder() 메서드
	 * 객체 생성 없이 사용하기 위해 static으로 선언한다.
	 * @return Builder 객체
	 */
	public static Builder builder() {
		return new Builder();
	}
	
	/**
	 * 정적 내부 클래스 Builder
	 * - Builder 내부의 메서드들은 Builder() 객체를 이용해서
	 *   자유롭게 사용가능하다. 각 메서드들을 통해
	 *   초기 값을 어떻게 할 지 세팅할 수 있다.
	 *   
	 *   어떤 메서드를 사용할 지 몇 개를 사용할 지와 상관없이
	 *   마지막에 build() 메서드를 호출하면 정해진 패턴의
	 *   Job 객체를 얻을 수 있다.
	 */
	public static class Builder {
		private String jobId; // 직종 아이디
		private String jobTitle; // 직종명
		private int minSalary; // 최소 급여
		private int maxSalary; // 최대 급여
		
		public Builder jobId(String jobId) {
			this.jobId = jobId;
			return this;
		}
		public Builder jobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}
		public Builder minSalary(int minSalary) {
			this.minSalary = minSalary;
			return this;
		}
		public Builder maxSalary(int maxSalary) {
			this.maxSalary = maxSalary;
			return this;
		}
		
		/**
		 * build() 메서드를 호출하면 내부에서 세팅된 Job 객체 획득가능.
		 * @return Job 객체
		 */
		public Job build() {
			Job job = new Job(jobId, jobTitle, minSalary, maxSalary);
			return job;
		}
	}
	
}
