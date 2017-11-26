
public interface Observer {

	public void update(Subject subject);

	public void setUpdateTime(long currentTimeMillis);
}