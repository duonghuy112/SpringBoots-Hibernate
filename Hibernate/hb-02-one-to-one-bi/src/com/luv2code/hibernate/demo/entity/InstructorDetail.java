package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "chanel")
	private String chanel;
	
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail", 
			cascade = {CascadeType.DETACH,
						CascadeType.MERGE,
						CascadeType.PERSIST,
						CascadeType.REFRESH	})
	@ToString.Exclude private Instructor instructor;

	public InstructorDetail(String chanel, String hobby) {
		this.chanel = chanel;
		this.hobby = hobby;
	}
}
