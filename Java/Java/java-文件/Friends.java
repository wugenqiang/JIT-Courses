
public class Friends extends Person{
	private Friends friends[];
	public void addFriends(Friends f)
	{
		boolean flag=true;
		for(int i=0;i<friends.length;i++)
		{
			if(friends[i].equals(f))
				flag=false;
		}
		if(flag)
		{
			this.friends[this.friends.length]=f;
			f.friends[f.friends .length]=this ;
		}
	}
	public Friends() {
		
	}

}
