package OCM.Model;

public enum Role {
	OVERLORD(0),
	STUDENT(1),
	TEACHER(2),
	DEFAULT(3)
	;
	
	private final int roleLevel;
	
	private Role(int roleLevel) {
		this.roleLevel = roleLevel;
	}
	
	public int getRoleLevel() {
		return this.roleLevel;
	}
	
	public static Role map(int roleLevel) {
		switch (roleLevel) {
			case 0: return OVERLORD;
			case 1: return STUDENT;
			case 2: return TEACHER;
			default: return DEFAULT;
		}
	}
}
