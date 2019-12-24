package com.softtek.academia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@Column(name="state_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long state_id;
	@Column(name="description")
	private String description_state;
	@Column(name="shipping_zone_id")
	private String shipping_zone;
	public Long getState_id() {
		return state_id;
	}
	public void setState_id(Long state_id) {
		this.state_id = state_id;
	}
	public String getDescription_state() {
		return description_state;
	}
	public void setDescription_state(String description_state) {
		this.description_state = description_state;
	}
	public String getShipping_zone() {
		return shipping_zone;
	}
	public void setShipping_zone(String shipping_zone) {
		this.shipping_zone = shipping_zone;
	}
	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", description_state=" + description_state + ", shipping_zone="
				+ shipping_zone + "]";
	}
	
	
}
