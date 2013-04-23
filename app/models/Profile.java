package models;



public class Profile {
	
	private String uuid;
	
	private String bio;
	
	private Boolean photo_profile;
	
	private String photo_path;
	
	private String profile_uuid;
	
	private Integer profile_number;
	
	private String gender;
	
	private Location location;
	
	private Category category;
	
	private Communication communication;
	
	
	
	
	public Profile(String uuid, Integer profile_number) {
		this.uuid = uuid;
		this.profile_number = profile_number;
		generateProfileUUID();
	}

	
	private void generateProfileUUID(){
		this.profile_uuid = UUIDGenerator.getUUID(this.uuid, String.valueOf(this.profile_number));
	}
	
	public String getProfileUUID(){
		return this.profile_uuid;
	}
	
	public void setBio(String bio){
		this.bio = bio;
	}
	
	public String getBio(){
		return this.bio;
	}
	
	public void setPhotoProfile(Boolean photo_profile){
		this.photo_profile = photo_profile;
	}
	
	public Boolean isPhotoProfile(){
		return this.photo_profile;
	}
	
	public void setPhotoPath(String path){
		this.photo_path = path;
	}
	
	public String getPhotoPaht(){
		return this.photo_path;
	}
	
	public void setGender( String gender){
		this.gender = gender;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	/*
	 * Create a profile
	 * 
	 */
	
	public static Profile createProfile(String uuid, Integer index){
		Profile profile = new Profile(uuid, index);
		return profile;
	}
	
	
}
