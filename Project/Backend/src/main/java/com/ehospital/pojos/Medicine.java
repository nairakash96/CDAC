package com.ehospital.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Medicine_Stock_Details",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Medicine extends BaseEntity{
	

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int quantity;
	

	
}
