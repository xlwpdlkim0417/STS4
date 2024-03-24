package _sb0322.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member2 {
	private int id;
	private String name;
	private int age;
	private String email;
	private String memo;

	public Member2(String name, int age, String email, String memo) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.memo = memo;
	}

	public Member2(String name, int age, String email, String memo, int id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.memo = memo;
	}

	public Member2(int id) {
		super();
		this.id = id;
	}

}
