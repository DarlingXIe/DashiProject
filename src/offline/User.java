package offline;
/*
 * 	
 * LinkItem is a project to provide better item recommendation (Books, Music Instruments, etc.) using Amazon’s dataset
 * 
	Extracted and purified features from Amazon dataset and prepared dataset for testing
	Designed a MapReduce program in MongoDB to calculate similarity scores between users
	Designed an algorithm based on similarity scores to improve recommendation precision.
	Tested the performance among 583k items and 10 categories

 * 
 * 
 * 
 * */





public class User implements Comparable<User>{
	private String id;
	private Double value;
	public User(String id, Double value) {
		super();
		this.id = id;
		this.value = value;
	}
	@Override
	public int compareTo(User other) {
		return (int) (other.value - this.value);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
