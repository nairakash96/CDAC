package com.ehospital.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Bed_Inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Bed extends BaseEntity{

	@Column(nullable = false)
	private int status;
}
