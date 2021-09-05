package br.com.ifs;

import java.util.Objects;

public class SpecimeDTO {
	private int specimeId;
	private String latitude;
	private String longitude;
	private String description;
	private int plantId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecimeDTO other = (SpecimeDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude) && plantId == other.plantId
				&& specimeId == other.specimeId;
	}

	@Override
	public String toString() {
		return "SpecimeDTO [specimeId=" + specimeId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", description=" + description + ", plantId=" + plantId + "]";
	}

	public int getSpecimeId() {
		return specimeId;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getDescription() {
		return description;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setSpecimeId(int specimeId) {
		this.specimeId = specimeId;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

}
